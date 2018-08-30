// @ModelAttribute - BindingResult의 사용
package bitcamp.mvc.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.mvc.vo.Member;

@RestController 
@RequestMapping("/exam12_1") 
public class Exam12_1 {
    
    // 예1) 서블릿 요청 파라미터를 int 타입(age 프로퍼티)으로 변환하지 못해 오류가 발생하는 예
    //
    // 클라이언트로부터 요청이 들어 오면 프론트 컨트롤러는 페이지 컨트롤러의 요청 핸들러를 호출한다. 
    // 요청 핸들러를 호출하기 위해서는 먼저 요청 핸들러의 아규먼트 값을 준비해야 한다.
    // 아규먼트로 서블릿 요청 파라미터를 원한다면 그 값을 준비한다.
    // 서블릿 요청 파라미터 값을 특정 value object에 담아 주기를 원한다면
    // 그 객체를 만들고 그 객체의 프로퍼티에 담아서 요청 핸들러에게 넘긴다.
    // 이렇게 서블릿 요청 파라미터 값을 변수나 객체에 담는 것을 "data binding" 이라 부른다.
    // 서블릿 요청 파라미터는 모두 문자열이기 때문에 데이터 바인딩 과정에서 
    // 문자열을 객체의 프로퍼티 타입으로 바꾸는 것이 필요하다. 
    // 만약 문자열을 해당 타입으로 바꾸는 중에 오류가 발생한다면
    // 프론트 컨트롤러는 요청 핸들러를 호출하지 못하고 예외가 발생시킬 것이다.
    //  
    // 테스트
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_1/test01?name=홍길동&age=xx
    // => 서블릿 요청 파라미터 중에서 age 값을 Member의 프로퍼티 age의 int 타입으로 변환할 수 없어서 오류가 발생할 것이다.  
    @GetMapping(value="test01")
    public Object test01(Member member) {
        return member;
    }
    
    // 예2) 데이터 바인딩에서 오류가 발생하면 요청 핸들러에게 전달하여 처리하도록 유도하기
    // 
    // 서블릿 요청 파라미터 값을 받는 변수 뒤에 곧 바로 BindingResult 변수를 선언한다.
    // 즉 데이터 바인딩 중에 오류가 발생하더라도 예외를 던지지 말고 이 변수에 담아 달라는 의미다. 
    // 그러면 요청 핸들러에서 할 일은 호출될 때 이 변수의 값을 확인하여 
    // 오류가 발생했으면 해당 오류를 처리하고 발생하지 않았으면 원래 하려던 일을 하면 된다.
    // 
    // 테스트
    // => http://localhost:8080/java106-spring-webmvc/mvc/exam12_1/test02?name=홍길동&age=xx
    // => 서블릿 요청 파라미터 중에서 age 값을 Member의 프로퍼티 age의 int 타입으로 변환할 수 없어서 오류가 발생하지만
    //    그 오류 정보를 BindingResult 객체에 보관한 후 요청 핸들러를 계속 호출한다.
    @GetMapping(value="test02")
    public Object test02(Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "Error!";
        }
        
        return member;
    }
    
    // 예3) 서블릿 요청 파라미터 값을 낱개의 변수로 받을 때는 BindingResult가 소용없다. 
    @GetMapping(value="test03")
    public Object test03(String name, int age, BindingResult result) {
        if (result.hasErrors()) {
            return "Error!";
        }
        
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        return member;
    }
}







