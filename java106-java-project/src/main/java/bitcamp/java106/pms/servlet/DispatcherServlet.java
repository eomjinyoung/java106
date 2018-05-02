// 서블릿 컨테이너가 실행하는 서버 프로그램
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;
import bitcamp.java106.pms.controller.Controller;

// 하는 일:
// => 클라이언트가 요청이 들어오면 그 요청을 컨트롤러에게 위임하는 역할
// => 스프링 IoC 컨테이너를 사용하여 컨트롤러 및 DAO 등을 관리한다.
// 
@WebServlet("/*") // 클라이언트의 모든 요청을 이 서블릿이 처리하겠다는 선언이다. 
public class DispatcherServlet implements Servlet {
    
    ApplicationContext iocContainer;
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 최초의 요청이 들어오면 딱 한 번 실행한다.
        // 그래서 서블릿이 실행하는데 필요한 자원을 준비하는 코드를 여기에 두면 된다.
        this.config = config;
        
        // 스프링 IoC 컨테이너 객체 생성
        // => 파라미터로 넘기는 값은 스프링 IoC 컨테이너 관련 설정작업을 수행하는 클래스 정보이다.
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public ServletConfig getServletConfig() {
        // 서블릿 설정 정보를 리턴하는 일을 한다.
        // => init()에서 넘겨 받은 값을 잘 보관하고 있다가 리턴하면 된다.
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 클라이언트 요청이 들어올 때 마다 서블릿 컨테이너가 호출하는 메서드
        // => 여기에 클라이언트의 요청을 처리하는 코드를 두면 된다. 
        
        // 파라미터의 값을 원래의 객체로 형변환 한다.
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // 클라이언트가 요청한 자원의 이름을 알아낸다.
        String path = request.getPathInfo();
        Controller controller = (Controller) iocContainer.getBean(path);
        
        if (controller != null) {
            controller.service(
                    new ServerRequestAdapter(request), 
                    new ServerResponseAdapter(response));
        } else {
            out.println("해당 명령을 처리할 수 없습니다.");
        }
        

    }

    @Override
    public String getServletInfo() {
        // 서블릿에 대한 정보를 간단한 문자열로 리턴한다.
        return "요청 처리를 중계하는 서블릿";
    }

    @Override
    public void destroy() {
        // 서버를 종료하기 전에 서블릿 컨테이너가 호출한다.
        // => 여기에는 서블릿이 실행되는 동안 만들었던 자원을 해제하는 코드를 두면 된다.
        //    예를 들어, 파일이나 DB 커넥션, 소켓 등의 자원을 해제한다.
        
    }

}

// 톰캣 서버에 프로그램 배치하기 
// 1) 프로그램 폴더를 만든다. 
//    => $톰캣홈/webapps/pms 폴더 생성
// 2) 자바 클래스 파일을 둘 폴더를 만든다.
//    => $톰캣홈/webapp/pms/WEB-INF/classes 폴더 생성
// 3) 컴파일된 클래스 파일 및 패키지를 배치한다.
//    => 프로젝트/bin/main/* --> WEB-INF/classes/* 복사한다.
// 4) 외부 라이브러리를 배치한다.
//    => *.jar --> WEB-INF/lib/*.jar 복사한다.
//
// *.jar 파일을 복사하는 방법
// => gradle을 이용하여 이클립스 설정파일을 만든 경우
//    이클립스에서 컴파일하거나 실행할 때 사용하는 외부 라이브러리는 
//    gradle이 관리하는 라이브러리이다. 
// => 이 라이브러리를 배포하려면 gradle 을 통해 라이브러리를 복사해야 한다.
//    > gradle build 실행!
//   그러면 build/
//
// 애플리케이션 실행
// 1) 톰캣 서버를 실행 또는 재실행
// 2) 웹브라우저에서 요청
//    => localhost:8888/pms/board/list











