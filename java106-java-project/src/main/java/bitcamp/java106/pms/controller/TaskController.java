// 팀 작업 관리 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TaskController {
    
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao, 
            TaskDao taskDao, TeamMemberDao teamMemberDao, MemberDao memberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
        this.memberDao = memberDao;
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
        
        if (menu.equals("task/add")) {
            this.onTaskAdd(team);
        } else if (menu.equals("task/list")) {
            this.onTaskList(team);
        } else if (menu.equals("task/view")) {
            this.onTaskView(team);
        } else if (menu.equals("task/update")) {
            this.onTaskUpdate(team);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(team);
        } else if (menu.equals("task/state")) {
            this.onTaskState(team);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    private void onTaskAdd(final Team team) {
        Task task = new Task(team);
        
        System.out.println("[팀 작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setStartDate(team.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() < team.getStartDate().getTime()) {
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        System.out.print("종료일? ");
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(team.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) {
                task.setEndDate(team.getEndDate());
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.print("작업자 아이디? ");
        String memberId = keyScan.nextLine();
        if (memberId.length() != 0) {
            if (!teamMemberDao.isExist(team.getName(), memberId)) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(this.memberDao.get(memberId));
            }
        }
        
        taskDao.insert(task);
    }

    
    private void onTaskList(final Team team) {
        System.out.println("[팀 작업 목록]");
        
        Task[] tasks = taskDao.list(team.getName());
        
        for (Task task : tasks) {
            System.out.printf("%d,%s,%s,%s,%s\n", 
                    task.getNo(), task.getTitle(), 
                    task.getStartDate(), task.getEndDate(),
                    (task.getWorker() == null) ? 
                            "-" : task.getWorker().getId());
        }
        System.out.println();
    }
    
    private void onTaskView(final Team team) {
        System.out.println("[작업 정보]");
        System.out.print("작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.printf("작업명: %s\n", task.getTitle());
        System.out.printf("시작일: %s\n", task.getStartDate());
        System.out.printf("종료일: %s\n", task.getEndDate());
        System.out.printf("작업자: %s\n", 
                (task.getWorker() == null) ? "-" : task.getWorker().getId());
        System.out.printf("작업상태: %s\n", getStateLabel(task.getState()));
    }
    
    private void onTaskUpdate(final Team team) {
        System.out.println("[팀 작업 변경]");
        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task originTask = taskDao.get(taskNo);
        if (originTask == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        Task task = new Task(team);
        task.setNo(originTask.getNo());
        
        System.out.printf("작업명(%s)? ", originTask.getTitle());
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setTitle(originTask.getTitle());
        } else {
            task.setTitle(str);
        }
        
        System.out.printf("시작일(%s)? ", originTask.getStartDate());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setStartDate(originTask.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() < team.getStartDate().getTime()) {
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        System.out.printf("종료일(%s)? ", originTask.getEndDate());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(originTask.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) {
                task.setEndDate(team.getEndDate());
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.printf("작업자 아이디(%s)? ", 
                (originTask.getWorker() == null) ? 
                        "-" : originTask.getWorker().getId());
        String memberId = keyScan.nextLine();
        if (memberId.length() == 0) {
            task.setWorker(originTask.getWorker());
        } else {
            if (!teamMemberDao.isExist(team.getName(), memberId)) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(this.memberDao.get(memberId));
            }
        }
        
        if (Console.confirm("변경하시겠습니까?")) {
            taskDao.update(task);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }

    private void onTaskDelete(final Team team) {
        System.out.println("[팀 작업 삭제]");
        System.out.print("삭제할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        if (Console.confirm("삭제하시겠습니까?")) {
            taskDao.delete(task.getNo());
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }
    
    private void onTaskState(final Team team) {
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

//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
