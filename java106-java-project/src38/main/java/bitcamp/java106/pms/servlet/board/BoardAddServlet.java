package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        // 스프링 IoC 컨테이너에서 서블릿 객체를 관리하는 것이 아니기 때문에
        // 스프링 IoC 컨테이너에 들어 있는 DAO 객체를 자동으로 주입 받을 수 없다.
        // 서블릿을 생성할 때 스프링 IoC 컨테이너에서 직접 DAO를 꺼내와야 한다.
        boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        try {
            Board board = new Board();
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));

            boardDao.insert(board);
            response.sendRedirect("list");
            
        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta http-equiv='Refresh' content='5;url=list'>");
            out.println("<title>게시물 등록</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>게시물 등록 실패</h1>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}

//ver 38 - redirect 적용
//ver 37 - BoardAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 






