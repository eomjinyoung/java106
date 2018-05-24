package bitcamp.java106.pms.servlet.team;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/delete")
public class TeamDeleteServlet extends HttpServlet {

    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = 
                WebApplicationContextUtils.getWebApplicationContext(
                        this.getServletContext()); 
        teamDao = iocContainer.getBean(TeamDao.class);
        teamMemberDao = iocContainer.getBean(TeamMemberDao.class);
        taskDao = iocContainer.getBean(TaskDao.class);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        
        
        try {
            teamMemberDao.delete(name);
            taskDao.deleteByTeam(name);
            int count = teamDao.delete(name);
            if (count == 0) {
                throw new Exception ("해당 팀이 없습니다.");
            }
            response.sendRedirect("list");
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 삭제 실패!");
            요청배달자.forward(request, response);
        }
    }
    
}

//ver 40 - CharacterEncodingFilter 필터 적용.
//         request.setCharacterEncoding("UTF-8") 제거
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.