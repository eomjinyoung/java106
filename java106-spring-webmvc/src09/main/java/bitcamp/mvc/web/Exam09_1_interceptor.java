// 인터셉터 - 페이지 컨트롤러를 실행하기 전후에 개입하기. 필터와 같은 역할을 한다.
package bitcamp.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 인터셉터(interceptor)
// => 서블릿의 Filter는 서블릿 실행 전후에 개입하는 객체이다.
// => 인터셉터는 페이지 컨트롤러 실행 전후와 JSP 실행 후에 개입하는 객체이다.
// => 인터셉터는 HandlerInterceptor를 구현해야 한다.
// => 배치 방법?
//    1) 자바 코드 
//    2) XML : mvc-servlet.xml 을 참고하라!
// => 사용 예)
//    - 사용자 인증 또는 권한 검사할 때 
//    - 로그를 남길 때 
//    - 페이지 컨트롤러를 실행하기 전에 클라이언트가 보낸 데이터를 암호 해제할 때
//    - 클라이언트에게 보낼 데이터를 암호화시킬 때
//    - 콘텐트의 압축 또는 해제 
// 
public class Exam09_1_interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Exam09_1_interceptor.preHandler()");
        return true; // 다음 인터셉터 또는 페이지 컨트롤러를 실행하려면 true
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Exam09_1_interceptor.postHandle()");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Exam09_1_interceptor.afterCompletion()");
    }
}







