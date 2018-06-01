// 웹 애플리케이션을 시작할 때 실행시키는 클래스
package step12;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// ServletContextLisetener 인터페이스를 구현하면 서블릿 컨테이너가 알아서 찾느냐?
// => 아니다! 찾으라고 표시해야 한다.
// 어떻게?
// => 다음과 같이 애노테이션을 붙이거나 또는 web.xml에 등록해야 한다.
//
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 서블릿 컨테이너가 웹 애플리케이션을 시작할 때 
        // 이 객체의 이 메서드를 호출한다.
        System.out.println("===> MyServletContextListener.contextInitialized()");
        
        // 웹 애플리케이션을 시작하자 마다 바로 이 메서드를 호출하기 때문에 
        // 이 메서드에서는 
        // 서블릿 컨테이너가 본격적으로 서블릿을 실행하기 전에
        // 그 서블릿들이 작업하는데 필요한 도구를 준비시키는 코드를 둔다.
        // 예) 스프링 IoC 컨테이너를 준비 
    }
}








