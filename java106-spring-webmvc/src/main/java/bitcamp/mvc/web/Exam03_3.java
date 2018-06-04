// @RequestMapping - GET/POST/PUT 등 요청 구분 III
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam03_3") 
public class Exam03_3 {
    
    // RequestMapping의 method 속성을 사용하면 특정 요청에만 호출되도록 할 수 있다.
    // 테스트 방법: /exam03_3.html
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1() {
        return "Exam03_3.m1()";
    }
    
    // RequestMapping의 method 속성을 사용하면 특정 요청에만 호출되도록 할 수 있다.
    // 테스트 방법: /exam03_3.html 
    @PostMapping(value="m2")  
    @ResponseBody  
    public String m2() {
        return "Exam03_3.m2()";
    }
    
    
    
}
