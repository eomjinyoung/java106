package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
    
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        Board board = new Board();
        board.setNo(Integer.parseInt(request.getParameter("no")));
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(new Date(System.currentTimeMillis()));
        
        try {
            int count = boardDao.update(board);
            if (count == 0) {
                out.println("해당 게시물이 존재하지 않습니다.");
            } else {
                out.println("변경하였습니다.");
            }
        } catch (Exception e) {
            out.println("변경 실패!");
            e.printStackTrace(out);
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 update() 메서드를 추출하여 클래스로 정의.
