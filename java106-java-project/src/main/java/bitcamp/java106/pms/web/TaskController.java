package bitcamp.java106.pms.web;

import java.beans.PropertyEditorSupport;
import java.net.URLEncoder;
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
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Controller
@RequestMapping("/task")
public class TaskController {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;

    public TaskController(TeamDao teamDao,
            TaskDao taskDao,
            TeamMemberDao  teamMemberDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping("/add")
    public String add(
            Task task,
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        Team team = teamDao.selectOne(task.getTeam().getName());
        if (team == null) {
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        }
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", task.getTeam().getName());
        params.put("memberId", task.getWorker().getId());
        
        if (task.getWorker().getId().length() > 0 &&
            !teamMemberDao.isExist(params)) {
            throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
        }
        
        taskDao.insert(task);
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
        // 응답 헤더의 값으로 한글을 포함할 때는 
        // 서블릿 컨테이너가 자동으로 URL 인코딩 하지 않는다.
        // 위와 같이 개발자가 직접 URL 인코딩 해야 한다.
    }
    
    @RequestMapping("/delete")
    public String delete(
            @RequestParam("no") int no,
            @RequestParam("teamName") String teamName) throws Exception {
        
        int count = taskDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 작업이 존재하지 않습니다.");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
        // 응답 헤더의 값으로 한글을 포함할 때는 
        // 서블릿 컨테이너가 자동으로 URL 인코딩 하지 않는다.
        // 위와 같이 개발자가 직접 URL 인코딩 해야 한다.
    }
    
    @RequestMapping("/form")
    public String form(
            @RequestParam("teamName") String teamName,
            Map<String,Object> map) throws Exception {
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Member> members = teamMemberDao.selectListWithEmail(teamName);
        map.put("members", members);
        return "/task/form.jsp";
    }
    
    @RequestMapping("/list")
    public String list(
            @RequestParam("teamName") String teamName,
            Map<String,Object> map) throws Exception {
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        List<Task> list = taskDao.selectList(team.getName());
        map.put("list", list);
        return  "/task/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(
            Task task,
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        int count = taskDao.update(task);
        if (count == 0) {
            throw new Exception("<p>해당 작업이 없습니다.</p>");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
            // 응답 헤더의 값으로 한글을 포함할 때는 
            // 서블릿 컨테이너가 자동으로 URL 인코딩 하지 않는다.
            // 위와 같이 개발자가 직접 URL 인코딩 해야 한다.
    }
    
    @RequestMapping("/view")
    public String view(
            @RequestParam("no") int no,
            Map<String,Object> map) throws Exception {
        
        Task task = taskDao.selectOne(no);
        if (task == null) {
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        }
        
        List<Member> members = teamMemberDao.selectListWithEmail(
                task.getTeam().getName());
        
        map.put("task", task);
        map.put("members", members);
        return "/task/view.jsp";
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
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
