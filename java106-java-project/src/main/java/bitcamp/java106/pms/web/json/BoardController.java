package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Board board) throws Exception {
        boardService.add(board);
    }
    
    @RequestMapping("delete")
    //@ResponseStatus(HttpStatus.OK) // 응답 상태 코드 값의 기본은 "200(OK)" 이다.
    public void delete(@RequestParam("no") int no) throws Exception {
        boardService.delete(no);
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize) {        
        return boardService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // 기본 값이 OK 이다. 
    public void update(Board board) throws Exception {
        boardService.update(board);
    }
    
    @RequestMapping("{no}")
    public Board view(@PathVariable int no) throws Exception {
        return boardService.get(no);
    }

}

//ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 생성






