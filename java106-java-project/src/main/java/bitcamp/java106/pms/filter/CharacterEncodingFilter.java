// 클라이언트가 보낸 데이터의 문자집합을 지정하는 필터
package bitcamp.java106.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // 모든 서블릿을 실행하기 전에 작업을 수행하는 필터
public class CharacterEncodingFilter implements Filter {
    
    FilterConfig config; 
    String encoding = "UTF-8";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        
        if (config.getInitParameter("encoding") != null) {
            this.encoding = config.getInitParameter("encoding");
        }
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // 서블릿을 실행하기 전에 클라이언트가 보낸 데이터에 대해 문자표를 지정한다.
        request.setCharacterEncoding(this.encoding);
        
        // 다음 필터가 있다면 그 필터의 doFilter()를 호출하고,
        // 없다면 요청한 서블릿의 service()를 호출한다.
        chain.doFilter(request, response);
        
        // service() 호출한 후에 특별히 처리할 작업이 있다면 여기에 작성한다.
    }
}








