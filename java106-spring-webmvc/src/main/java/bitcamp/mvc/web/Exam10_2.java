// JSON 데이터 출력하기 - Gson 라이브러리로 JSON 데이터 출력하기 
package bitcamp.mvc.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam10_2") 
public class Exam10_2 {
    
    BoardDao boardDao;
    
    public Exam10_2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping(value="list", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String list() {
        List<Board> boards = boardDao.selectList();
        
        // Gson 라이브러리를 이용하여 객체를 JSON 문자열로 변환한다.
        String json = new Gson().toJson(boards);
        
        // 그리고 그 JSON 문자열을 출력한다.
        return json;
    }
    
    @GetMapping(value="list2")
    @ResponseBody
    public Object list2() {
        List<Board> boards = boardDao.selectList();
        // 요청 핸들러의 리턴 값이 @ResponseBody일 경우,
        // 일반 객체를 리턴하면 
        // 스프링에서 자동으로 JSON으로 바꿔 응답한다.
        return boards;
    }
}







