// 웹 애플리케이션 컴포넌트 : 필터
package step09.ex1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 웹 애플리케이션 컴포넌트?
// - 서블릿(servlet): 클라이언트의 요청을 처리하는 역할
// - 필터(filter): 서블릿을 실행하기 전/후에 보조 작업을 수행
// - 리스너(listener): 서블릿 컨테이너에서 특정 사건이 발생할 때 작업을 수행
// 
// 필터
// - 서블릿을 실행하기 전이나 후에 특정 작업을 수행하고 싶을 때 사용한다.
// - 예: 
//   => 클라이언트의 접속을 기록
//   => 클라이언트가 보낸 데이터의 압축을 해제
//   => 클라이언트가 보낸 데이터의 암호를 해제
//   => 서블릿을 작업을 수행하기 전에 공통으로 처리해야 하는 작업을 수행
//   => 클라이언트의 인증 또는 권한 검사
//   => 클라이언트에게 보낼 데이터를 압축하거나 암호화시키기
// 
// 필터 만들기
// - javax.servlet.Filter 인터페이스 구현
// 
// 필터 배치
// 1) 애노테이션으로 필터를 배치하기
//    @WebFilter(필터를 적용할 URL)
// 2) DD File(web.xml)에 필터를 배치하기
//    - 필터 등록
//    <filter>
//        <filter-name>filter1</filter-name>
//        <filter-class>step09.ex1.Filter1</filter-class>
//    </filter>
//   - 필터를 적용할 URL 지정
//    <filter-mapping>
//        <filter-name>filter1</filter-name>
//        <url-pattern>/step09/ex1/*</url-pattern>
//    </filter-mapping>
//
@WebFilter("/step09/ex1/*")
public class Filter1 implements Filter {
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 최소로 필터 객체가 생성될 때 호출된다.
        // 필터가 작업할 때 사용할 도구를 준비시키는 코드를 여기에 둔다.
        this.config = filterConfig;
        System.out.println("Filter1.init()");
    }
    
    @Override
    public void destroy() {
        // 웹 애플리케이션을 멈추거나 서블릿 컨테이너를 멈출 때 호출된다.
        // 필터가 init()를 통해 준비했던 도구나 자원을 해제시키는 코드를 여기에 둔다.
        System.out.println("Filter1.destroy()");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 서블릿을 실행하기 전에 필터가 적용될 때 마다 호출된다.
        // 서블릿이 클라이언트 요청을 처리하는데 필요한 것들을 여기에서 준비한다.
        
        System.out.println("Filter1.doFilter() : before");
        
        // 필터의 작업을 수행한 후 다음 필터를 실행한다.
        // 만약 다음 필터가 없으면 원래 목적지인 서블릿을 실행한다.
        chain.doFilter(request, response);
        
        // 서블릿을 실행한 후에 수행할 작업이 있다면 바로 chain.doFilter() 다음에 두어라!
        System.out.println("Filter1.doFilter() : after");
    }
    
}






