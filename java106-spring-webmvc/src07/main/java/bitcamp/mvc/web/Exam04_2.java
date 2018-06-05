// @RequestMapping - HTTP 헤더로 메서드 구분하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam04_2") 
public class Exam04_2 {
    
    // HTTP 요청에서 특정 헤더의 존재 유무에 따라 호출될 메서드를 구분할 수 있다.
    // 테스트 방법: 
    // 예1) exam04_2.html 
    @GetMapping(value="get", headers="name")  
    @ResponseBody  
    public String m1() {
        return "Exam04_2.m1()";
    }
    
    @GetMapping(value="get", headers="age")  
    @ResponseBody  
    public String m2() {
        return "Exam04_2.m2()";
    }
    
    @GetMapping(value="get", headers= {"name","age"})  
    @ResponseBody  
    public String m3() {
        return "Exam04_2.m3()";
    }
}







