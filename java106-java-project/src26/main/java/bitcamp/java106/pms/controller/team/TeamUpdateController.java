// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;

@Component("team/update")
public class TeamUpdateController implements Controller {

    Scanner keyScan;
    TeamDao teamDao;
    
    public TeamUpdateController(Scanner scanner, TeamDao teamDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
    }

    public void service(String menu, String option) {
        System.out.println("[팀 정보 변경]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        
        Team team = teamDao.get(option);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team();
            System.out.printf("팀명 : %s\n", team.getName());
            updateTeam.setName(team.getName());
            System.out.printf("설명(%s)? ", team.getDescription());
            updateTeam.setDescription(this.keyScan.nextLine());
            System.out.printf("최대인원(%d)? ", team.getMaxQty());
            updateTeam.setMaxQty(this.keyScan.nextInt());
            this.keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.getStartDate());
            updateTeam.setStartDate(Date.valueOf(this.keyScan.nextLine()));
            System.out.printf("종료일(%s)? ", team.getEndDate());
            updateTeam.setEndDate(Date.valueOf(this.keyScan.nextLine()));
            
            int index = teamDao.indexOf(updateTeam.getName());
            teamDao.update(index, updateTeam);
            System.out.println("변경하였습니다.");
        }
    }
}

//ver 26 - TeamController에서 update() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.