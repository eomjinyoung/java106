package bitcamp.java106.pms.web.json;

import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
    
    BoardService boardService;
    
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("add")
    public String add(Board board) throws Exception {
        boardService.add(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        
        int count = boardService.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize) {        
        return boardService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        
        int count = boardService.update(board);
        if (count == 0) {
            throw new Exception("해당 게시물이 존재하지 않습니다.");
        } 
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public Board view(@PathVariable int no) throws Exception {
        return boardService.get(no);
    }

}

//ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 생성






