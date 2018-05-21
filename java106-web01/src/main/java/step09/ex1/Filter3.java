// 웹 애플리케이션 컴포넌트 : FilterConfig의 활용
package step09.ex1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 애노테이션 대신에 web.xml에 배치 정보를 설정한다.
//@WebFilter("/step09/ex1/exam03") 
public class Filter3 implements Filter {
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // FilterConfig 도구를 사용하여 web.xml에 설정된 파라미터 값을 가져올 수 있다.
        String v1 = config.getInitParameter("v1");
        String v2 = config.getInitParameter("v2");
        System.out.printf("v1=%s, v2=%s\n", v1, v2);
        
        chain.doFilter(request, response);
    }
    
}






