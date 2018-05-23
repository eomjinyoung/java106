package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/member/list")
public class TeamMemberListServlet extends HttpServlet {

    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = 
                WebApplicationContextUtils.getWebApplicationContext(
                        this.getServletContext()); 
        teamMemberDao = iocContainer.getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // including 하기 전의 서블릿에서 문자셋을 지정할 것이고
        // 이미 getParameter()를 호출했을 것이기 때문에 다음 코드는 의미가 없다.
        //request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");

        // including 하기 전의 서블릿에서 콘텐트 타입을 설정했을 것이기 때문에 다음 코드는 의미가 없다.
        //response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        try {
            List<Member> members = teamMemberDao.selectListWithEmail(name);
            
            out.println("<h2>회원 목록</h2>");
            out.println("<form action='member/add' method='post'>");
            out.println("<input type='text' name='memberId' placeholder='회원아이디'>");
            out.printf("<input type='hidden' name='teamName' value='%s'>\n", name);
            out.println("<button>추가</button>");
            out.println("</form>");
            out.println("<table border='1'>");
            out.println("<tr><th>아이디</th><th>이메일</th><th> </th></tr>");
            for (Member member : members) {
                out.printf("<tr>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td><a href='member/delete?teamName=%s&memberId=%s'>삭제</a></td>"
                        + "</tr>\n", 
                        member.getId(), 
                        member.getEmail(),
                        name,
                        member.getId());
            }
            out.println("</table>");
               
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 멤버 조회 실패!");
            요청배달자.forward(request, response);
        }
    }
}

//ver 39 - forward 적용
