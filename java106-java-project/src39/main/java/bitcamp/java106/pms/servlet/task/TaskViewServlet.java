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
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/view")
public class TaskViewServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
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
        out.println("<title>작업 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>작업 보기</h1>");
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            
            Task task = taskDao.selectOne(no);
            if (task == null) {
                throw new Exception("해당 작업을 찾을 수 없습니다.");
            }
            
            List<Member> members = teamMemberDao.selectListWithEmail(
                    task.getTeam().getName());
            
            out.println("<form action='update' method='post'>");
            out.printf("<input type='hidden' name='no' value='%d'>\n", no);
            out.println("<table border='1'>");
            out.println("<tr>");
            out.printf("    <th>팀명</th>"
                    + "<td><input type='text' name='teamName' value='%s' readOnly></td>\n",
                    task.getTeam().getName());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>작업명</th>"
                    + "<td><input type='text' name='title' value='%s'></td>\n",
                    task.getTitle());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>시작일</th>"
                    + "<td><input type='date' name='startDate' value='%s'></td>",
                    task.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>종료일</th>"
                    + "<td><input type='date' name='endDate' value='%s'></td>",
                    task.getEndDate());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>작업자</th>");
            out.println("    <td>");
            out.println("        <select name='memberId'>");
            out.println("            <option value=''>--선택 안함--</option>");
            
            for (Member member : members) {
                out.printf("            <option %s>%s</option>\n",
                        (member.equals(task.getWorker())) ? "selected" : "",
                        member.getId());
            }
            
            out.println("        </select>");
            out.println("    </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>작업상태</th><td><select name='state'>");
            out.printf("        <option value='0' %s>작업대기</option>\n",
                    (task.getState() == 0) ? "selected" : "");
            out.printf("        <option value='1' %s>작업중</option>\n",
                    (task.getState() == 1) ? "selected" : "");
            out.printf("        <option value='9' %s>작업완료</option>\n",
                    (task.getState() == 9) ? "selected" : "");
            out.println("    </select></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<button>변경</button> ");
            out.printf("<a href='delete?no=%d&teamName=%s'>삭제</a>\n", 
                    no, task.getTeam().getName());
            out.println("</form>");

        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 상세조회 실패!");
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
//ver 26 - TaskController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
