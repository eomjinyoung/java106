// 로그인 여부를 검사하는 인터셉터 - 로그인 사용자만 서비스를 사용하게 한다.
package bitcamp.java106.pms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import bitcamp.java106.pms.domain.Member;

public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        
        if (loginUser == null) { // 로그인을 하지 않았으면 로그인 폼으로 보낸다.
            response.sendRedirect(request.getContextPath() + "/app/auth/form");
            return false;
        }
        
        // 로그인 했으면 다음 인터셉터나 페이지 컨트롤러를 실행한다. 
        return true;
    }
}







