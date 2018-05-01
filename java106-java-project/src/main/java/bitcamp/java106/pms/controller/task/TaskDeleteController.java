// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/delete")
public class TaskDeleteController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskDeleteController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            int count = taskDao.delete(no);
            if (count == 0) {
                out.println("해당 작업이 존재하지 않습니다.");
            } else {
                out.println("삭제하였습니다.");
            }
        } catch (Exception e) {
            out.println("삭제 실패!");
            out.println("잠시 후 다시 시도해주세요. 계속 오류 발생 시 ");
            out.println("담당자(내선: 120)에게 연락주세요.");
            e.printStackTrace(out);
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
