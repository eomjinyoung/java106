package bitcamp.java106.pms.web;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;

@Controller
@RequestMapping("/team")
public class TeamController {

    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    public TeamController(
            TeamDao teamDao, 
            TeamMemberDao teamMemberDao,
            TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @RequestMapping("/add")
    public String add(Team team) throws Exception {
        
        teamDao.insert(team);
        return "redirect:list.do";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("name") String name) throws Exception {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", name);
        
        teamMemberDao.delete(params);
        
        taskDao.deleteByTeam(name);
        
        int count = teamDao.delete(name);
        
        if (count == 0) {
            throw new Exception ("해당 팀이 없습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(Map<String,Object> map) throws Exception {
        
        List<Team> list = teamDao.selectList();
        map.put("list", list);
        return "/team/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Team team) throws Exception {
        
        int count = teamDao.update(team);
        if (count == 0) {
            throw new Exception("<p>해당 팀이 존재하지 않습니다.</p>");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/view")
    public String view(
            @RequestParam("name") String name,
            Map<String,Object> map) throws Exception {
        
        Team team = teamDao.selectOneWithMembers(name);
        if (team == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        map.put("team", team);
        return "/team/view.jsp";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(java.sql.Date.valueOf(text));
                    }
                });
    }
    
}

//ver 51 - Spring WebMVC 적용
//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
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
//ver 26 - TeamController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.