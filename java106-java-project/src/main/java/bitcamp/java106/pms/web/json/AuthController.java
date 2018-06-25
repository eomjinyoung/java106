// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.web.json;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    MemberService memberService;
     
    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping("/loginUser")
    public Member loginUser(HttpSession session) {
        return (Member) session.getAttribute("loginUser");
    }
    
    @RequestMapping("/login")
    public String login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam(value="saveId",required=false) String saveId,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception {
        
        Cookie cookie = null;
        if (saveId != null) {
            // 입력폼에서 로그인할 때 사용한 ID를 자동으로 출력할 수 있도록 
            // 웹브라우저로 보내 저장시킨다.
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else { // "아이디 저장" 체크박스를 체크하지 않았다면 
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0); // 웹브라우저에 "id"라는 이름으로 저장된 쿠키가 있다면 제거한다.
            // 즉 유효기간을 0으로 설정함으로써 "id"라는 이름의 쿠키를 무효화시키는 것이다.
        }
        response.addCookie(cookie);
        
        if (memberService.isExist(id, password)) { // 로그인 성공!
            session.setAttribute("loginUser", memberService.get(id));

            // 로그인 하기 전의 페이지로 이동한다.
            String refererUrl = (String)session.getAttribute("refererUrl");
            
            if (refererUrl == null || 
                refererUrl.contains("login.do") ||
                refererUrl.endsWith("/auth/form.jsp")) { 
                // 이전 페이지가 없다면 메인 화면으로 이동시킨다.
                return "redirect:/"; // => "/java106-java-project"
            } else { 
                // 이전 페이지가 있다면 그 페이지로 이동시킨다.
                return "redirect:" + refererUrl;
            }
            
        } else { // 로그인 실패!
            session.invalidate();
            return "auth/fail";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(
            HttpServletRequest request,
            HttpSession session) throws Exception {
        
        // 세션을 꺼내 무효화시킨다.
        session.invalidate();
        
        // 웹 애플리케이션의 시작 페이지로 가라고 웹브라우저에게 얘기한다.
        return "redirect:/"; // ==> "/java106-java-project"
    }
}

//ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 생성
