// JSON 데이터 출력하기 - 스프링 설정과 + 잭슨 라이브러리로 JSON 데이터 출력하기
package bitcamp.mvc.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

// JSON 데이터를 출력하는 페이지 컨트롤러일 경우 
// 다음의 애노테이션을 사용하여 표시하라!
@RestController 
@RequestMapping("/exam10_3") 
public class Exam10_3 {
    
    BoardDao boardDao;
    
    public Exam10_3(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping(value="list")
    public Object list() {
        List<Board> boards = boardDao.selectList();
        
        // @RestController에서 요청 핸들러(요청이 들어왔을 때 호출되는 메서드; 요청을 처리하는 메서드)의
        // 리턴 값은 객체이다. 
        return boards;
    }
}







