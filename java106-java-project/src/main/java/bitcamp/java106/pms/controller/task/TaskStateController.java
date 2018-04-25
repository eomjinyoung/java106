// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/state")
public class TaskStateController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskStateController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            int state = Integer.parseInt(request.getParameter("state"));
            if (!(state == Task.READY || 
                 state == Task.WORKING || 
                 state == Task.COMPLETE)) {
                out.println("올바르지 않은 값입니다. 이전 상태를 유지합니다!");
                return;
            }
            
            int count = taskDao.updateState(no, state);
            if (count == 0) {
                out.println("해당 작업이 없습니다.");
            } else {
                out.printf("작업 상태를 '%s'로 변경하였습니다.\n", 
                        getStateLabel(state));
            }
        } catch (Exception e) {
            out.println("상태 변경 실패!");
            e.printStackTrace(out);
        }
    }
    
    // 다음 메서드와 같이 인스턴스 변수를 사용하지 않는 메서드라면,
    // static을 붙여 클래스 메서드로 만들라!
    public static String getStateLabel(int state) {
        switch (state) {
        case Task.READY: return "작업대기";
        case Task.WORKING: return "작업중";
        case Task.COMPLETE: return "작업완료";
        default:
            return null;
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 state() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
