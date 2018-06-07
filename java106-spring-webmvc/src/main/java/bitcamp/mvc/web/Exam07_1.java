// 경로 변수 - URL에서 값을 추출하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam07_1") 
public class Exam07_1 {
    
    @GetMapping(value="m1", 
                produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, int age) {
        return String.format("m1(): name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m2/{name}/{age}", 
                produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @PathVariable String name, 
            @PathVariable int age) {
        return String.format("m2(): name=%s, age=%d", name, age);
    }
}







