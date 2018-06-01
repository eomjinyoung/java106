package bitcamp.mvc.web.json;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.mvc.dao.BoardDao;

@Controller("web.json.BoardController")
public class BoardController {
    
    BoardDao boardDao;
    
    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping("/board/list")
    public String list(Map<String,Object> map) {
        
        map.put("list", boardDao.selectList());
        
        return "/board/list.jsp";
    }
}






