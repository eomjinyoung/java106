// JSON 데이터 출력하기 - 적용 전 
package bitcamp.mvc.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam10_1") 
public class Exam10_1 {
    
    BoardDao boardDao;
    
    public Exam10_1(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping("list")
    public String list(Model model) {
        List<Board> boards = boardDao.selectList();
        model.addAttribute("boards", boards);
        
        // JSP로 보내서 DAO가 리턴한 게시물 목록을 가지고 HTML을 만들게 한다.
        // 그렇게 만든 HTML은 웹브라우저로 보내져서 출력될 것이다.
        return "exam10_1";
    }
}







