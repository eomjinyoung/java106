package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class MyWebApplicationInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 웹 애플리케이션을 시작할 때 이 메서드를 호출한다. 누가?
        System.out.println("===> MyWebApplicationInitializer.onStartup()");
    }

}
