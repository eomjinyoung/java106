package bitcamp.java106.pms;


import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

// ver 0.5 - help 명령을 구현한다.
// ver 0.4 - quit 명령어 입력 시 반복문을 종료한다.
// ver 0.3 - 사용자로부터 입력 받는 것을 무한 반복한다.
// ver 0.2 - 사용자로부터 입력을 받아 출력한다.
// ver 0.1 - 명령 입력 프롬프트를 출력한다. 
public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while (true) {
            System.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            }

            System.out.println(input);
        }

    }
}