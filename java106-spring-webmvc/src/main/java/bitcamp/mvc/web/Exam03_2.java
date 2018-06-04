// @RequestMapping - GET/POST/PUT 등 요청 구분 II
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam03_2") 
public class Exam03_2 {
    
    // RequestMapping의 method 속성을 사용하면 특정 요청에만 호출되도록 할 수 있다.
    // 테스트 방법: /exam03_2.html 
    @RequestMapping(value="m1", method=RequestMethod.GET)  
    @ResponseBody  
    public String m1() {
        return "Exam03_2.m1()";
    }
    
    // RequestMapping의 method 속성을 사용하면 특정 요청에만 호출되도록 할 수 있다.
    // 테스트 방법: /exam03_2.html 
    @RequestMapping(value="m2", method=RequestMethod.POST)  
    @ResponseBody  
    public String m2() {
        return "Exam03_2.m2()";
    }
    
    
    
}
