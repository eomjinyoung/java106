// @ControllerAdvice 사용 - 공통 예외 처리
package bitcamp.mvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.mvc.vo.Member;

@RestController 
@RequestMapping("/exam13_1") 
public class Exam13_1 {
    
    @GetMapping(value="test01")
    public Object test01(Member member) {
        
        // 컨트롤러에서 예외가 발생한다면?
        // => 프론트 컨트롤러에서 클라이언트로 예외 내용을 출력한다.
        // => 이것을 조정하고 싶다면, @ExceptionHandler 를 사용하라!
        //    그리고 가능한 @ControllerAdvice로 처리하는 것이 편하다.
        throw new RuntimeException("예외 발생!");
        
    }
    
}


