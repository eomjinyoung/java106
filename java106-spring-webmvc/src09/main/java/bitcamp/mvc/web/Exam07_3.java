// URL에서 값을 추출하기 - 정규표현식으로 값 추출하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam07_3") 
public class Exam07_3 {
    
    @GetMapping(value="m1/{value}", 
                produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(@PathVariable String value) {
        // 예) 클라이언트에서 URL에 다음과 같은 형식으로 데이터를 보낼 때,
        //        .../exam07_3/m1/teamA-hong-100
        return String.format("m1(): value=%s", value);
    }
    
    // URI가 특정 규칙과 일치할 때 메서드를 호출하게 할 수 있다.
    // 정규표현식으로 그 규칙을 제어한다.
    @GetMapping(value="m2/{team:t[a-zA-Z]+}-{member:m[a-z0-9]+}-{doc:[0-9]+}", 
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @PathVariable String team,
            @PathVariable String member,
            @PathVariable int doc) {
        
        
        // 예) 클라이언트에서 URL에 다음과 같은 형식으로 데이터를 보낼 때,
        //        .../exam07_3/m2/teamA-hong-100
        return String.format("m2(): team=%s, member=%s, doc=%d", 
                team, member, doc);
    }
    
}







