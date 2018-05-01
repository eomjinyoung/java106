package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/delete")
public class BoardDeleteController implements Controller {
    BoardDao boardDao;
    
    public BoardDeleteController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            int count = boardDao.delete(no);
            
            if (count == 0) {
                out.println("해당 게시물이 없습니다.");
            } else {
                out.println("삭제하였습니다.");
            }
        } catch (Exception e) {
            out.println("삭제 실패!");
            e.printStackTrace(out);
        }
    }
    
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 delete() 메서드를 추출하여 클래스로 정의. 
