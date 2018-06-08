// 세션 다루기 - HttpSession에 보관된 데이터 꺼내기
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller 
@RequestMapping("/exam08_4") 
@SessionAttributes({"name","age"})
// 세션의 값을 @ModelAttribute를 사용하여 꺼내려면 
// 마찬가지로 @SessionAttributes 애노테이션을 사용하여 꺼낼 값의 이름을 지정해야 한다. 
public class Exam08_4 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpSession session) {
        // 세션에 보관된 값을 꺼내 출력하기
        return String.format("m1(): name=%s, age=%d, working=%b", 
                session.getAttribute("name"),
                session.getAttribute("age"),
                session.getAttribute("working"));
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) {
        // 세션을 무효화하기
        session.invalidate();
        return String.format("m2(): 세션 무효화시킴!");
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(
            // @SessionAttributes에 지정된 값을 꺼낼 때는 @ModelAttribute 를 사용하라!
            @ModelAttribute("name") String name, 
            @ModelAttribute("age") int age,

            // @SessionAttributes에 지정된 값이 아니거나 없을 때는 오류가 발생한다!
            @ModelAttribute("working") boolean working) {
        // 세션에 보관된 값을 꺼내 출력하기
        return String.format("m3(): name=%s, age=%d, working=%b", 
                name, age, working);
    }
    
    @GetMapping(value="m4", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(
            @ModelAttribute("name") String name, 
            @ModelAttribute("age") int age) {
        // 세션에 보관된 값을 꺼내 출력하기
        return String.format("m4(): name=%s, age=%d", 
                name, age);
    }
     
}







