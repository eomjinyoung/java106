package bitcamp.java106.pms.controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/task/form")
public class TaskFormController {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;

    public TaskFormController(TeamDao teamDao,
            TeamMemberDao  teamMemberDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping
    public String form(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        String teamName = request.getParameter("teamName");
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        request.setAttribute("members", members);
        return "/task/form.jsp";
    }
}

//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - CharacterEncodingFilter 필터 적용.
//         request.setCharacterEncoding("UTF-8") 제거
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
