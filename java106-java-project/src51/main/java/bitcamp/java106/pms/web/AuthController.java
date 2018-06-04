// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.web;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    MemberDao memberDao;
     
    public AuthController(MemberDao memberDao) {
        this.memberDao = memberDao;
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
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        
        Member member = memberDao.selectOneWithPassword(params);
        
        if (member != null) { // 로그인 성공!
            session.setAttribute("loginUser", member);

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
            return "/auth/fail.jsp";
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

//               [웹브라우저]                                  [웹서버] 
// GET 요청: /java106-java-project/auth/login ===>
//                                                       <=== 응답: 로그인폼 
// POST 요청: /java106-java-project/auth/login ===>
//                                                       <=== 응답: redirect URL
// GET 요청: /java106-java-project ===> 
//                                                       <=== 응답: index.html
// 메인화면 출력!

//ver 51 - redirect URL 변경
//ver 50 - DAO 변경에 따른 메서드 호출 변경
//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 41 - 클래스 추가




