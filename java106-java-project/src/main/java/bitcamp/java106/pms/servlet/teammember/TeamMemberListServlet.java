package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.util.List;

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

        String name = request.getParameter("name");

        try {
            List<Member> members = teamMemberDao.selectListWithEmail(name);
            request.setAttribute("members", members);
            request.getRequestDispatcher("/team/member/list.jsp").include(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 멤버 조회 실패!");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

//ver 42 - JSP 적용
//ver 39 - forward 적용
