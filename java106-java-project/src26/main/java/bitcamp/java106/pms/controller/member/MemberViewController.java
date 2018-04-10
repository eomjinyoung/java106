// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;

@Component("member/view")
public class MemberViewController implements Controller {
    Scanner keyScan;

    MemberDao memberDao;
    
    public MemberViewController(Scanner scanner, MemberDao memberDao) {
        this.keyScan = scanner;
        this.memberDao = memberDao;
    }

    public void service(String menu, String option) {
        System.out.println("[회원 정보 조회]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(option);

        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디: %s\n", member.getId());
            System.out.printf("이메일: %s\n", member.getEmail());
            System.out.printf("암호: %s\n", member.getPassword());
        }
    }
}

//ver 26 - MemberController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - MemberDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 MemberDao를 사용한다.
//         onMemberList()에서 배열의 각 항목에 대해 null 값을 검사하는 부분을 제거한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - MemberDao를 생성자에서 주입 받도록 변경.
// ver 14 - MemberDao를 사용하여 회원 데이터를 관리한다.
