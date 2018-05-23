package step09.ex3;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // <context-param> 태그의 값을 꺼내려면 ServletContext 객체가 있어야 한다.
        ServletContext sc = sce.getServletContext();
        
        System.out.printf("step09.ex3.Listener1 => %s, %s\n", 
                sc.getInitParameter("p1"), sc.getInitParameter("p2"));
    }
}







