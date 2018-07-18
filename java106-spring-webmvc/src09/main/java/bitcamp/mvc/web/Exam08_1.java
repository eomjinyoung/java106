// 세션 다루기 - HttpSession에 데이터 보관하기
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam08_1") 
public class Exam08_1 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, HttpSession session) {
        // 테스트:
        //      http://localhost:8888/java106-spring-webmvc/mvc/exam08_1/m1?name=hong
        // 세션에 데이터 보관
        session.setAttribute("name", name);
        
        return String.format("m1(): 세션에 직접 값을 넣기 - name=%s", name);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(int age, HttpSession session) {
        // 테스트:
        //      http://localhost:8888/java106-spring-webmvc/mvc/exam08_1/m2?age=20
        // 세션에 데이터 보관
        session.setAttribute("age", age);
        
        return String.format("m2(): 세션에 직접 값을 넣기 - age=%d", age);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(boolean working, HttpSession session) {
        // 테스트:
        //      http://localhost:8888/java106-spring-webmvc/mvc/exam08_1/m3?working=true
        // 세션에 데이터 보관
        session.setAttribute("working", working);
        
        return String.format("m3(): 세션에 직접 값을 넣기 - working=%b", working);
    }
    
   
}







