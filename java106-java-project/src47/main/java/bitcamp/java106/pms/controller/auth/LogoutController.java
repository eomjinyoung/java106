// 로그아웃 처리 서블릿 - 세션을 무효화시킨다.
package bitcamp.java106.pms.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.web.RequestMapping;

@Component("/auth/logout")
public class LogoutController {
    
    @RequestMapping
    public String logout(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        // 세션을 꺼내 무효화시킨다.
        request.getSession().invalidate();
        
        // 웹 애플리케이션의 시작 페이지로 가라고 웹브라우저에게 얘기한다.
        return "redirect:" + request.getContextPath(); // ==> "/java106-java-project"
    }
}

//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 41 - 클래스 추가