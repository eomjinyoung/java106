// 요청 핸들러의 파라미터 - HTTP 요청 헤더 값 받기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_6") 
public class Exam05_6 {
    
    // @RequestHeader("헤더명") 을 사용하면 HTTP 요청 헤더의 값을 파라미터로 받을 수 있다.
    @GetMapping(value="m1", produces="text/plain")  
    @ResponseBody  
    public String m1(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(required=false, value="Content-Type") String contentType,
            @RequestHeader("Accept") String accept) {
        return String.format("m1():\n %s\n %s\n %s\n", userAgent, contentType, accept);
    }
    
}







