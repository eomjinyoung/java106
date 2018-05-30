package bitcamp.java106.pms.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board/list")
public class BoardListController {
    
    BoardDao boardDao;
    
    public BoardListController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {        
            
        List<Board> list = boardDao.selectList();
        request.setAttribute("list", list);
        return "/board/list.jsp";
    }
}

//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
//ver 37 - BoardListController를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 list() 메서드를 추출하여 클래스로 정의. 
