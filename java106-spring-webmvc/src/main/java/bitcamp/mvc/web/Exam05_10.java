// 요청 핸들러의 파라미터 - @RequestPart를 사용하여 multipart/form-data 형식으로 넘어온 값 꺼내기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_10") 
public class Exam05_10 {
    
    // 멀티파트 형식으로 넘어 온 데이터를 꺼낼 때 
    // 파라미터에 @RequestPart를 붙인다.
    
    // 테스트: 
    // http://localhost:8888/java106-spring-webmvc/exam05_10.html
    @PostMapping(value="m1")
    @ResponseBody
    public String m1(
            String name, 
            int age, 
            String photo) {
        return String.format("m1(): name=%s, age=%d, photo=%s", name, age, photo);
    }
    
   
}







