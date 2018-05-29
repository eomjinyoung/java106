package bitcamp.java106.pms.controller.task;

import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component("/task/update")
public class TaskUpdateController implements PageController {
    
    TaskDao taskDao;
    
    public TaskUpdateController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        String teamName = request.getParameter("teamName");
        
        Task task = new Task()
            .setNo(Integer.parseInt(request.getParameter("no")))
            .setTitle(request.getParameter("title"))
            .setStartDate(Date.valueOf(request.getParameter("startDate")))
            .setEndDate(Date.valueOf(request.getParameter("endDate")))
            .setState(Integer.parseInt(request.getParameter("state")))
            .setTeam(new Team().setName(request.getParameter("teamName")))
            .setWorker(new Member().setId(request.getParameter("memberId")));
        
        int count = taskDao.update(task);
        if (count == 0) {
            throw new Exception("<p>해당 작업이 없습니다.</p>");
        }
        return "redirect:list.do?teamName=" + URLEncoder.encode(teamName, "UTF-8");
            // 응답 헤더의 값으로 한글을 포함할 때는 
            // 서블릿 컨테이너가 자동으로 URL 인코딩 하지 않는다.
            // 위와 같이 개발자가 직접 URL 인코딩 해야 한다.
    }
    
}

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
//ver 26 - TaskController에서 update() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
