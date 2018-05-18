package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/classroom/list")
public class ClassroomListServlet extends HttpServlet {
    
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        classroomDao = InitServlet.getApplicationContext().getBean(ClassroomDao.class);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>강의 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>강의 목록</h1>");
        
        try {
            List<Classroom> list = classroomDao.selectList();
            
            out.println("<p><a href='form.html'>새 강의</a></p>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>번호</th><th>강의명</th><th>기간</th><th>강의실</th>");
            out.println("</tr>");
            
            for (Classroom classroom : list) {
                out.println("<tr>");
                out.printf("    <td>%d</td>\n", classroom.getNo());
                out.printf("    <td><a href='view?no=%d'>%s</a></td>\n", 
                        classroom.getNo(), classroom.getTitle());
                out.printf("    <td>%s~%s</td>\n",
                        classroom.getStartDate(), classroom.getEndDate());
                out.printf("    <td>%s</td>\n", classroom.getRoom());
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "강의 목록조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 39 - forward 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 list() 메서드를 추출하여 클래스로 정의.

