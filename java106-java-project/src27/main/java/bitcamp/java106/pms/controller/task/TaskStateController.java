// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component("task/state")
public class TaskStateController implements Controller {
    
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskStateController(Scanner scanner, 
            TeamDao teamDao, 
            TaskDao taskDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    public void service(String menu, String option) {
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(option);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", option);
            return;
        }
        
        System.out.println("[작업 진행 상태]");
        System.out.print("상태를 변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.printf("'%s' 작업의 상태: %s\n", 
                task.getTitle(), getStateLabel(task.getState()));
        
        System.out.print("변경할 상태?(0:작업대기, 1:작업중, 9:작업완료) ");
        int state = Integer.parseInt(keyScan.nextLine());
        
        if (state == Task.READY || state == Task.WORKING || 
                state == Task.COMPLETE) {
            task.setState(state);
            System.out.printf("작업 상태를 '%s'로 변경하였습니다.\n", 
                    getStateLabel(state));
        } else {
            System.out.println("올바르지 않은 값입니다. 이전 상태를 유지합니다!");
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

//ver 26 - TaskController에서 state() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
