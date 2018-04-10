// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;

@Component("team/add")
public class TeamAddController implements Controller {

    Scanner keyScan;
    TeamDao teamDao;
    
    public TeamAddController(Scanner scanner, TeamDao teamDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
    }

    public void service(String menu, String option) {
        System.out.println("[팀 정보 입력]");
        Team team = new Team();

        System.out.print("팀명? ");
        team.setName(this.keyScan.nextLine());

        System.out.print("설명? ");
        team.setDescription(this.keyScan.nextLine());

        System.out.print("최대인원? ");
        team.setMaxQty(this.keyScan.nextInt());
        this.keyScan.nextLine(); 

        System.out.print("시작일? ");
        team.setStartDate(Date.valueOf(this.keyScan.nextLine()));

        System.out.print("종료일? ");
        team.setEndDate(Date.valueOf(this.keyScan.nextLine()));

        teamDao.insert(team);
    }
}

//ver 26 - TeamController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.