// 요청 핸들러의 파라미터 - 클라이언트가 보낸 데이터를 객체로 받기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam05_3") 
public class Exam05_3 {
    
    // 프론트 컨트롤러로부터 클라이언트가 보낸 값들을 객체에 담아서 받을 수 있다.
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(Board board) {
        return String.format("m1(): no=%d, title=%s, content=%s", 
                board.getNo(),
                board.getTitle(),
                board.getContent());
    }
}







