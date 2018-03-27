// 팀 작업 관리 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

public class TaskController {
    
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao, TaskDao taskDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            this.onTaskList(option);
        } else if (menu.equals("task/view")) {
            //this.onTeamMemberList(option);
        } else if (menu.equals("task/update")) {
            //this.onTeamMemberList(option);
        } else if (menu.equals("task/delete")) {
            //this.onTeamMemberDelete(option);
        } else if (menu.equals("task/state")) {
            //this.onTeamMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onTaskAdd(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
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
            Member member = team.getMember(memberId);
            if (member == null) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(member);
            }
        }
        
        taskDao.insert(task);
    }

    
    void onTaskList(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", teamName);
            return;
        }

        System.out.println("[팀 작업 목록]");
        
        Task[] tasks = taskDao.list(teamName);
        
        for (Task task : tasks) {
            System.out.printf("%d,%s,%s,%s,%s\n", 
                    task.getNo(), task.getTitle(), 
                    task.getStartDate(), task.getEndDate(),
                    (task.getWorker() == null) ? 
                            "-" : task.getWorker().getId());
        }
        System.out.println();
    }

    /*
    void onTeamMemberDelete(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("삭제할 팀원은? ");
        String memberId = keyScan.nextLine();
        
        if (!team.isExist(memberId)) {
            System.out.println("이 팀의 회원이 아닙니다.");
            return;
        }

        team.deleteMember(memberId);
        
        System.out.println("[팀 멤버 삭제]");
        System.out.println("삭제하였습니다.");
    }
    */
}

//ver 17 - 클래스 생성
