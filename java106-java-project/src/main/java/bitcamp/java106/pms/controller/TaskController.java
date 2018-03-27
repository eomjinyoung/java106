// 팀 작업 관리 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

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
            this.onTaskView(option);
        } else if (menu.equals("task/update")) {
            this.onTaskUpdate(option);
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
    
    void onTaskView(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", teamName);
            return;
        }

        System.out.println("[작업 정보]");
        System.out.print("작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(teamName, taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    teamName, taskNo);
            return;
        }
        
        System.out.printf("작업명: %s\n", task.getTitle());
        System.out.printf("시작일: %s\n", task.getStartDate());
        System.out.printf("종료일: %s\n", task.getEndDate());
        System.out.printf("작업자: %s\n", 
                (task.getWorker() == null) ? "-" : task.getWorker().getId());
    }
    
    void onTaskUpdate(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.println("[팀 작업 변경]");
        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task originTask = taskDao.get(teamName, taskNo);
        if (originTask == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    teamName, taskNo);
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
            Member member = team.getMember(memberId);
            if (member == null) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(member);
            }
        }
        
        if (Console.confirm("변경하시겠습니까?")) {
            taskDao.update(task);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
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
