// @ModelAttribute - @SessionAttributes와 @ModelAttribute
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import bitcamp.mvc.vo.Member;

@RestController 
@RequestMapping("/exam12_3")
@SessionAttributes({"member", "user", "admin"})
public class Exam12_3 {
    
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
        
        Member user = new Member();
        user.setName("테스트2");
        user.setEmail("test2@test.com");
        user.setId("test2");
        user.setPassword("1111");
        user.setAge(30);
        
        session.setAttribute("user", user);
        
        Member guest = new Member();
        guest.setName("테스트3");
        guest.setEmail("test3@test.com");
        guest.setId("test3");
        guest.setPassword("1111");
        guest.setAge(40);
        
        session.setAttribute("guest", guest);
        
        return "test01()...ok";
    }
    
    // 예1) 세션에 저장된 객체 받기 
    // => 요청 핸들러에서 프론트 컨트롤러에게 아규먼트를 요구할 때,
    // => HttpSession에 보관된 값을 받고 싶다면 @ModelAttribute 애노테이션을 붙여라.
    //      @ModelAttribute("세션에 보관할 때 사용한 key")
    // => 단 @ModelAttribute에서 지정하는 이름은 @SessionAttributes에 등록된 이름이어야 한다.
    //
    // 테스트
    // => 세션 객체를 먼저 준비하기 위해 test01()을 먼저 호출해야 한다.
    //    http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test01
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test02
    @GetMapping(value="test02")
    public Object test02(
            @ModelAttribute("member") Member m1,
            @ModelAttribute("user") Member m2,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test02(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        
        return new Member[] {m1, m2};
    }
    
    // 예2) 세션에 저장된 객체 받기 + 파라미터 값 받기 
    // => 세션에 저장된 객체를 받는다. 
    // => 서블릿 요청 파라미터 중에서 세션 객체의 프로퍼티와 일치하는 이름이 있다면
    //    요청 파라미터 값을 세션 객체의 프로퍼티에 저장한다. 
    // 테스트
    // => 세션 객체를 먼저 준비하기 위해 test01()을 먼저 호출해야 한다.
    //    http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test01
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test03?name=홍길동&age=xx
    //
    @GetMapping(value="test03")
    public Object test03(
            @ModelAttribute("member") Member m,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test03(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        
        return m;
    }
    
    // 예3) 세션에 보관된 객체라 하더라도 @SessionAttributes에 등록되지 않은 경우에는 
    //     그냥 빈 객체를 받는다. 
    //     
    // 테스트
    // => 세션 객체를 먼저 준비하기 위해 test01()을 먼저 호출해야 한다.
    //    http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test01
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test04
    @GetMapping(value="test04")
    public Object test04(
            @ModelAttribute("guest") Member m,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test04(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        
        return m;
    }
    
    // 예4) @SessionAttributes에는 등록되어 있는데 실제 세션에는 없는 경우에 예외가 발생한다.
    //     
    // 테스트
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_3/test05
    @GetMapping(value="test05")
    public Object test05(
            @ModelAttribute("admin") Member m,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("test05(): 서블릿 요청 파라미터 값 변환 오류");
            System.out.println(result);
        }
        
        return m;
    }
    
    @ExceptionHandler(HttpSessionRequiredException.class)
    public ResponseEntity<String> handle(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.OK);
    }

}







