package bitcamp.java106.pms.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

public class WebApplicationContextUtils {
    // 실제 스프링 WebMVC 프레임워크에서는 
    // 웹 애플리케이션 별로 IoC 컨테이너를 관리한다.
    // 이를 모방하여 만들기 위해 다음과 같이 맵에서 보관하는 방식을 사용하였다.
    public static Map<ServletContext, ApplicationContext> containers = 
            new HashMap<>();
    
    // 웹 애플리케이션에서 사용할 IoC 컨테이너를 꺼내고 싶다면,
    // 파라미터에 웹 애플리케이션 정보를 담고 있는 ServletContext를 넘겨줘야 한다.
    public static ApplicationContext getWebApplicationContext(ServletContext ctx) {
        return containers.get(ctx);
    }
}




