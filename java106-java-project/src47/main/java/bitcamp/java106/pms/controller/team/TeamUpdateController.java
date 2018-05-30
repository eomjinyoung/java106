package bitcamp.java106.pms.controller.team;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/update")
public class TeamUpdateController {

    TeamDao teamDao;
    
    public TeamUpdateController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    
    @RequestMapping
    public String update(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        Team team = new Team();
        team.setName(request.getParameter("name"));
        team.setDescription(request.getParameter("description"));
        team.setMaxQty(Integer.parseInt(request.getParameter("maxQty")));
        team.setStartDate(Date.valueOf(request.getParameter("startDate")));
        team.setEndDate(Date.valueOf(request.getParameter("endDate")));
        
        int count = teamDao.update(team);
        if (count == 0) {
            throw new Exception("<p>해당 팀이 존재하지 않습니다.</p>");
        }
        return "redirect:list.do";
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
//ver 26 - TeamController에서 update() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.