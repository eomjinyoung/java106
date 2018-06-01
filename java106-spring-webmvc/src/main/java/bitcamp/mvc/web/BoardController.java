package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

@Controller("web.BoardController")
public class BoardController {
    
    BoardDao boardDao;
    
    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping("/board/add")
    public String add() {
        Board board = new Board();
        board.setTitle("제목입니다");
        board.setContent("내용입니다");
        
        boardDao.insert(board);
        
        return "/board/add.jsp";
    }
}






