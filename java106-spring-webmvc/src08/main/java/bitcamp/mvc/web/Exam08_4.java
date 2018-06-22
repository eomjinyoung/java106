// 세션 다루기 - @ModelAttribute를 사용하여 @SessionAttributes에 지정된 값 꺼내기 
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@RequestMapping("/exam08_4") 

// 세션 보관소에 저장하고 꺼낼 값의 이름을 지정한다.
@SessionAttributes({"name", "age", "working"})

public class Exam08_4 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            // 만약 세션에 보관된 값이 없다면 실행 오류가 발생한다!
            @ModelAttribute("name") String name, 
            @ModelAttribute("age") int age,
            @ModelAttribute("working") boolean working) {
        
        return String.format("m1(): @ModelAttribute로 세션 값 꺼내기 - name=%s, age=%d, working=%b", 
                name, age, working);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(SessionStatus status) {
        
        // SessionStatus로 세션에 보관된 값 없애기
        status.setComplete();
        
        return String.format("m2(): SessionStatus로 세션에 보관된 값 없애기");
    }
}







