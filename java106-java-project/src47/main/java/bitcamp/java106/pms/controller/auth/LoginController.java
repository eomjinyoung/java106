// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.controller.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/auth/login")
public class LoginController {
    
    MemberDao memberDao;
    
    public LoginController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping
    public String login(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        Cookie cookie = null;
        if (request.getParameter("saveId") != null) {
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
        
        Member member = memberDao.selectOneWithPassword(id, password);
        
        HttpSession session = request.getSession();
        
        if (member != null) { // 로그인 성공!
            session.setAttribute("loginUser", member);

            // 로그인 하기 전의 페이지로 이동한다.
            String refererUrl = (String)session.getAttribute("refererUrl");
            
            if (refererUrl == null) { 
                // 이전 페이지가 없다면 메인 화면으로 이동시킨다.
                return "redirect:" + request.getContextPath(); // => "/java106-java-project"
            } else { 
                // 이전 페이지가 있다면 그 페이지로 이동시킨다.
                return "redirect:" + refererUrl;
            }
            
        } else { // 로그인 실패!
            session.invalidate();
            return "/auth/fail.jsp";
        }
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

//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 41 - 클래스 추가




