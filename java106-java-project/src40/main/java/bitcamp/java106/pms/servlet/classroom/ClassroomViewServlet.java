package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/classroom/view")
public class ClassroomViewServlet extends HttpServlet {

    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = 
                WebApplicationContextUtils.getWebApplicationContext(
                        this.getServletContext()); 
        classroomDao = iocContainer.getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        int no = Integer.parseInt(request.getParameter("no"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>강의 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>강의 보기</h1>");
        
        try {
            Classroom classroom = classroomDao.selectOne(no);
    
            if (classroom == null) {
                throw new Exception("유효하지 않은 강의입니다.");
            }
            
            out.println("<form action='update' method='post'>");
            out.printf("<input type='hidden' name='no' value='%d'>\n", no);
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>강의명</th>");
            out.printf("    <td><input type='text' name='title' value='%s'></td>\n",
                    classroom.getTitle());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>시작일</th>");
            out.printf("    <td><input type='date' name='startDate' value='%s'></td>\n",
                    classroom.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>종료일</th>");
            out.printf("    <td><input type='date' name='endDate' value='%s'></td>\n",
                    classroom.getEndDate());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>강의실</th>");
            out.printf("    <td><input type='text' name='room' value='%s'></td>\n",
                    classroom.getRoom());
            out.println("</tr>");
            out.println("</table>");
            out.println("<p>");
            out.println("<a href='list'>목록</a>");
            out.println("<button>변경</button>");
            out.printf("<a href='delete?no=%d'>삭제</a>\n", no);
            out.println("</p>");
            out.println("</form>");
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "강의 상세조회 실패!");
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
//ver 26 - TeamController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.