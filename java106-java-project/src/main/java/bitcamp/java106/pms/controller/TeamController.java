// 팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // keyScan 변수에 저장하라!
    Scanner keyScan;

    TeamDao teamDao = new TeamDao();
    
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    
    public TeamController(Scanner scanner) {
        this.keyScan = scanner;
    }
    

    public void service(String menu, String option) {
        if (menu.equals("team/add")) {
            this.onTeamAdd();
        } else if (menu.equals("team/list")) {
            this.onTeamList();
        } else if (menu.equals("team/view")) {
            this.onTeamView(option);
        } else if (menu.equals("team/update")) {
            this.onTeamUpdate(option);
        } else if (menu.equals("team/delete")) {
            this.onTeamDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    int getTeamIndex(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    void onTeamAdd() {
        System.out.println("[팀 정보 입력]");
        Team team = new Team();

        System.out.print("팀명? ");
        team.name = this.keyScan.nextLine();

        System.out.print("설명? ");
        team.description = this.keyScan.nextLine();

        System.out.print("최대인원? ");
        team.maxQty = this.keyScan.nextInt();
        this.keyScan.nextLine(); 

        System.out.print("시작일? ");
        team.startDate = Date.valueOf(this.keyScan.nextLine());

        System.out.print("종료일? ");
        team.endDate = Date.valueOf(this.keyScan.nextLine());

        teamDao.insert(team);
    }

    void onTeamList() {
        System.out.println("[팀 목록]");
        Team[] list = teamDao.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n", 
                    list[i].name, list[i].maxQty, 
                    list[i].startDate, list[i].endDate);
        }
    }

    void onTeamView(String name) {
        System.out.println("[팀 정보 조회]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }
        
        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명: %s\n", team.name);
            System.out.printf("설명: %s\n", team.description);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n", 
                team.startDate, team.endDate);
        }
    }

    void onTeamUpdate(String name) {
        System.out.println("[팀 정보 변경]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        
        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team();
            System.out.printf("팀명 : %s\n", team.name);
            updateTeam.name = team.name;
            System.out.printf("설명(%s)? ", team.description);
            updateTeam.description = this.keyScan.nextLine();
            System.out.printf("최대인원(%d)? ", team.maxQty);
            updateTeam.maxQty = this.keyScan.nextInt();
            this.keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.startDate);
            updateTeam.startDate = Date.valueOf(this.keyScan.nextLine());
            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = Date.valueOf(this.keyScan.nextLine());
            
            teamDao.update(updateTeam);
            System.out.println("변경하였습니다.");
        }
    }

    void onTeamDelete(String name) {
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                teamDao.delete(team.name);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}

//ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.