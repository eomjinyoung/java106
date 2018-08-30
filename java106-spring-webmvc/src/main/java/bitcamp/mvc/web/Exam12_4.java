// @ModelAttribute - 세션 객체와 모델 객체
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import bitcamp.mvc.vo.Member;

@RestController 
@RequestMapping("/exam12_4")
@SessionAttributes({"member"})
public class Exam12_4 {
    
    @ModelAttribute
    public Member setUpMember() {
        System.out.println("setUpMember()");
        Member member = new Member();
        member.setId("model");
        member.setEmail("model@test.com");
        member.setPassword("1111");
        member.setName("모델");
        member.setAge(20);
        return member;
    }
    
    // 세션에 값 저장하기
    @GetMapping(value="test01")
    public Object test01(HttpSession session) {
        
        Member member = new Member();
        member.setName("테스트");
        member.setEmail("test@test.com");
        member.setId("test");
        member.setPassword("1111");
        member.setAge(20);
        
        session.setAttribute("member", member);
        
        return "test01()...ok";
    }
    
    // 예1) 세션 객체에도 "member" 이름으로 등록된 객체가 있고
    //     setUpMember()가 리턴하는 모델 객체도 있을 경우,
    //     모델 객체를 우선하여 받는다. 
    //
    // 테스트
    // => 세션 객체를 먼저 준비하기 위해 test01()을 먼저 호출해야 한다.
    //    http://localhost:8080/java106-spring-webmvc/mvc/exam12_4/test01
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_4/test02?name=홍길동&age=xx
    @GetMapping(value="test02")
    public Object test02(
            @ModelAttribute("member") Member m,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test02(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        
        return m;
    }
    

}







