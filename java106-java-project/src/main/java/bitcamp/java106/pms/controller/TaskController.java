// 팀 작업 관리 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public class TaskController {
    
    Scanner keyScan;
    TeamDao teamDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            //this.onTeamMemberList(option);
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
        System.out.println("작업등록...");
        /*
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.println("[팀 멤버 추가]");
        System.out.print("추가할 멤버의 아이디는? ");
        String memberId = keyScan.nextLine();
        
        Member member = memberDao.get(memberId);
        if (member == null) {
            System.out.printf("%s 회원은 없습니다.", memberId);
            return;
        }
        
        if (team.isExist(memberId)) {
            System.out.println("이미 등록된 회원입니다.");
            return;
        }
        
        team.addMember(member);
        */
    }

    /*
    void onTeamMemberList(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }

        System.out.println("[팀 멤버 목록]");
        System.out.print("회원들: ");
        
        Member[] members = team.getMembers();
        
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) continue;
            System.out.printf("%s, ", members[i].getId());
        }
        System.out.println();
    }

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
