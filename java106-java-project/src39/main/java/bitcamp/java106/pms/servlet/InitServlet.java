// 다른 서블릿들이 사용할 자원을 미리 준비시키는 역할을 수행한다.
package bitcamp.java106.pms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;

// 하는 일:
// => Spring IoC 컨테이너(bean container)를 준비한다. 
// 
@WebServlet(
        urlPatterns="/initServlet", // value 는 urlPatterns 와 같다. 
        loadOnStartup=1) 
@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
    
    static ApplicationContext iocContainer;
    
    public static ApplicationContext getApplicationContext() {
        return iocContainer;
    }
    
    @Override
    public void init() throws ServletException {
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }
    
    // 다른 서블릿이 사용할 자원을 준비하는 일만 하기 때문에 
    // 굳이 클라이언트의 요청을 처리할 service() 메서드를 구현할 필요가 없다.
}






