package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/list")
public class TaskListServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>작업 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1><a href='../team/view?name=%s'>%s</a>의 작업 목록</h1>\n", 
                teamName, teamName);
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                throw new Exception(teamName + " 팀은 존재하지 않습니다.");
            }
            List<Task> list = taskDao.selectList(team.getName());
            
            out.printf("<p><a href='add?teamName=%s'>새작업</a></p>\n", teamName);
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>");
            out.println("</tr>");
            
            for (Task task : list) {
                out.println("<tr>");
                out.printf("    <td>%d</td>", task.getNo());
                out.printf("    <td><a href='view?no=%d'>%s</a></td>", 
                        task.getNo(),
                        task.getTitle());
                out.printf("    <td>%s ~ %s</td>", 
                        task.getStartDate(),
                        task.getEndDate());
                out.printf("    <td>%s</td>\n", 
                        (task.getWorker() == null) ? "-" : task.getWorker().getId());
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 목록조회 실패!");
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
//ver 26 - TaskController에서 list() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
