// 프론트 컨트롤러 구현 
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.web.RequestMapping;
import bitcamp.java106.pms.web.RequestParam;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    
    @Override
    public void init() throws ServletException {
        // 이 서블릿을 생성할 때 이 서블릿이 사용할 Spring IoC 컨테이너를 준비한다.
        try {
            iocContainer = new ClassPathXmlApplicationContext(
                this.getServletConfig().getInitParameter("contextConfigLocation"));
            
            String[] beanNames = iocContainer.getBeanDefinitionNames();
            System.out.println("-----------------------------");
            for (String name : beanNames) {
                System.out.println(name);
            }
            System.out.println("-----------------------------");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // Front Controller
        // => 클라이언트의 모든 요청을 받아서 특정 컨트롤러에게 위임하기 전에 
        //    필요한 공통 기능 처리한다.
        // => 클라이언트의 진입점이 한 군데라서 유지보수가 용이하다.
        
        response.setContentType("text/html;charset=UTF-8");

        // 클라이언트가 요청한 서블릿의 경로를 알아내기
        String servletPath = request.getServletPath().replace(".do", "");
        
        // servletPath에서 객체명 추출하기
        // => 즉 맨 끝 / 이후의 문자열을 제외한 이름
        // => 예) /board/add  ===> /board
        int index = servletPath.lastIndexOf('/');
        String objName = servletPath.substring(0, index);
        String handlerPath = servletPath.substring(index);
        
        // 페이지 컨트롤러 실행
        try {
            // 클라이언트 요청을 처리할 페이지 컨트롤러를 얻기
            Object pageController = iocContainer.getBean(objName);
            
            // 클라이언트 요청을 처리하는 메서드(request handler)를 알아낸다.
            Method requestHandler = findRequestHandler(pageController, handlerPath);

            if (requestHandler == null)
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");

            // 요청 핸들러가 리턴해 줄 값을 담을 바구니 준비
            HashMap<String,Object> resultMap = new HashMap<>();
            
            // 요청 핸들러의 파라미터 값을 준비한다.
            Object[] paramValues = prepareParamValues(
                             requestHandler, request, response, resultMap);
            
            // 준비한 파라미터 값을 가지고 요청 핸들러를 호출한다. 
            String viewUrl = (String)requestHandler.invoke(
                                    pageController, paramValues);
            
            // 요청 핸들러를 실행한 후,
            // 요청 핸들러 저장한 작업 결과가 담겨 있는 resultMap의 값들을 ServletRequest로 옮긴다.
            // 왜? JSP가 꺼내 쓸 수 있도록 하기 위함.
            Set<String> keySet = resultMap.keySet();
            for (String key : keySet) {
                request.setAttribute(key, resultMap.get(key));
            }
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!", e);
        }
    }

    private Object[] prepareParamValues(
            Method requestHandler, 
            HttpServletRequest request,
            HttpServletResponse response, 
            HashMap<String, Object> resultMap) {
        
        // 파라미터 값을 저장할 바구니 준비
        ArrayList<Object> paramValues = new ArrayList<>();
        
        // 메서드의 파라미터 정보 알아내기
        Parameter[] params = requestHandler.getParameters();
        
        for (Parameter p : params) {
            if (p.getType() == Map.class) {
                paramValues.add(resultMap);
            } else if (p.getType() == HttpServletRequest.class) {
                paramValues.add(request);
            } else if (p.getType() == HttpServletResponse.class) {
                paramValues.add(response);
            } else if (p.getType() == HttpSession.class) {
                paramValues.add(request.getSession());
            } else if (isPrimitiveType(p.getType())) {
                paramValues.add(getRequestParamValue(p, request));
            } else {
                paramValues.add(getValueObject(p, request));
            }
        }
        
        return paramValues.toArray();
    }

    private Object getValueObject(Parameter p, HttpServletRequest request) {
        Class<?> clazz = p.getType();
        
        try {
            Constructor<?> defaultConstructor = clazz.getConstructor();
            Object valueObject = defaultConstructor.newInstance();
            
            Method[] methods = clazz.getMethods();
            
            for (Method m : methods) {
                if (!m.getName().startsWith("set")) continue;
                
                String propName = getPropertyName(m.getName());
                String propValue = request.getParameter(propName);
                
                // 클라이언트가 그 프로퍼티 이름으로 보낸 값이 없으면 건너 뛴다.
                if (propValue == null) continue;
                
                // 셋터에서 요구하는 파라미터 값의 타입이 String이나 primitive 타입이 아니면 건너 뛴다. 
                Class<?> setterParamType = m.getParameterTypes()[0];
                if (!isPrimitiveType(setterParamType)) continue;
                
                // 셋터 메서드를 호출하여 클라이언트가 보낸 값을 저장한다.
                m.invoke(valueObject, toPrimitiveValue(propValue, setterParamType));
            }
            
            return valueObject;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private String getPropertyName(String methodName) {
        // setFirstName ==> FirstName 추출 
        StringBuffer buf = new StringBuffer(methodName.substring(3));
        
        // 첫번째 알파벳을 소문자로 변경
        buf.setCharAt(0, Character.toLowerCase(buf.charAt(0)));
        
        return buf.toString();
    }

    private Object getRequestParamValue(Parameter p, HttpServletRequest request) {
        // 파라미터 정보로부터 @RequestParam 애노테이션 정보를 추출한다.
        RequestParam anno = p.getAnnotation(RequestParam.class);
        
        // 애노테이션 정보로부터 파라미터 이름을 꺼낸다.
        String paramName = anno.value();
        
        // 파라미터 이름을 사용하여 클라이언트가 보낸 데이터의 값을 꺼낸다.
        String value = request.getParameter(paramName);
        
        if (value == null) return null;
        
        // 클라이언트가 보낸 값은 문자열인데 그 문자열을 파라미터의 primitive 타입으로 바꿔 리턴한다.
        return toPrimitiveValue(value, p.getType());
    }
    
    private Object toPrimitiveValue(String value, Class<?> type) {
        if (type == byte.class) return Byte.parseByte(value);
        if (type == short.class) return Short.parseShort(value);
        if (type == int.class) return Integer.parseInt(value);
        if (type == long.class) return Long.parseLong(value);
        if (type == float.class) return Float.parseFloat(value);
        if (type == double.class) return Double.parseDouble(value);
        if (type == char.class) return value.charAt(0);
        if (type == boolean.class) return Boolean.parseBoolean(value);
        if (type == Date.class) return Date.valueOf(value);
        
        return value;
    }
    
    
    private boolean isPrimitiveType(Class<?> type) {
        if (type == byte.class ||
            type == short.class ||
            type == int.class ||
            type == long.class ||
            type == float.class ||
            type == double.class ||
            type == char.class ||
            type == boolean.class ||
            type == String.class ||
            type == Date.class)
            return true;
        return false;
    }

    private Method findRequestHandler(Object pageController, String handlerPath) throws Exception {
        Class<?> clazz = pageController.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null && anno.value().equals(handlerPath))
                return m;
        }
        return null;
    }
}

//ver 48 - CRUD 기능이 합쳐진 클래스에서 요청 핸들러 찾기
//ver 47 - @RequestMapping으로 요청 핸들러 찾기
//ver 46 - POJO 페이지 컨트롤러를 사용하여 클라이언트 요청 처리
//         이 프론트 컨트롤러가 사용할 페이지 컨트롤러는 
//         이 클래스에서 Spring IoC 컨테이너를 사용하여 관리할 것이다.
//         ContextLoaderListener의 스프링 IoC 컨테이너 생성 업무를 이 클래스로 이관한다. 
//ver 45 - 클래스 추가



