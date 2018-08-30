// @ModelAttribute - @ModelAttribute 메서드
package bitcamp.mvc.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.mvc.vo.Member;

@RestController 
@RequestMapping("/exam12_2") 
public class Exam12_2 {
    
    // @ModelAttribute
    // => 요청 핸들러의 아규먼트 값을 준비하는 메서드에 이 애노테이션을 붙인다.
    // => 이 애노테이션이 붙은 메서드는 요청 핸들러가 호출될 때 마다 먼저 호출된다. 
    // => 이 메서드가 리턴 타입과 요청 핸들러의 파라미터 타입이 일치하면 
    //    이 메서드의 리턴 값이 요청 핸들러의 아규먼트로 사용될 것이다. 
    //    
    @ModelAttribute
    public Member setUpMember() {
        System.out.println("setUpMember()");
        Member member = new Member();
        member.setId("test");
        member.setEmail("test@test.com");
        member.setPassword("1111");
        member.setName("테스트");
        member.setAge(20);
        return member;
    }
    
    // 예1) @ModelAttribute 메서드의 리턴 값 사용하기
    // => 프론트 컨트롤러가 요청 핸들러를 호출할 때 setUpMember()의 리턴 값을 아규먼트로 전달한다. 
    // 테스트
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_2/test01?name=홍길동&age=xx
    @GetMapping(value="test01")
    public Object test01(Member member, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test01(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        return member;
    }
    
    // 예2) 요청 핸들러의 파라미터에 @ModelAttribute 붙이기
    // => 붙여도 되고, test01() 처럼 생략해도 된다.
    // 테스트
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_2/test02?name=홍길동&age=xx
    @GetMapping(value="test02")
    public Object test02(@ModelAttribute Member member, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test02(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        return member;
    }
}







