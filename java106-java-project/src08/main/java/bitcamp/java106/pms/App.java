package bitcamp.java106.pms;

import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

// ver 0.2 - 회원 관리 기능을 별도의 클래스로 옮긴다.
//           => controller.MemberController 클래스 추가
// ver 0.1 - 팀 관리 기능(메서드)을 별도의 클래스로 옮긴다.
//           => controller.TeamController 클래스 추가
//           사용자 입력 기능을 별도의 클래스로 옮긴다.
//           => util.Console 클래스 추가
public class App {
    static Scanner keyScan = new Scanner(System.in);
    public static String option = null; 
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    public static void main(String[] args) {
        // 클래스를 사용하기 전에 필수 값을 설정한다.
        TeamController.keyScan = keyScan;
        MemberController.keyScan = keyScan;
        Console.keyScan = keyScan;

        while (true) {
            String[] arr = Console.prompt();

            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if (menu.equals("team/add")) {
                TeamController.onTeamAdd();
            } else if (menu.equals("team/list")) {
                TeamController.onTeamList();
            } else if (menu.equals("team/view")) {
                TeamController.onTeamView(option);
            } else if (menu.equals("team/update")) {
                TeamController.onTeamUpdate(option);
            } else if (menu.equals("team/delete")) {
                TeamController.onTeamDelete(option);
            } else if (menu.equals("member/add")) {
                MemberController.onMemberAdd();
            } else if (menu.equals("member/list")) {
                MemberController.onMemberList();
            } else if (menu.equals("member/view")) {
                MemberController.onMemberView(option);                
            } else if (menu.equals("member/update")) {
                MemberController.onMemberUpdate(option);                
            } else if (menu.equals("member/delete")) {
                MemberController.onMemberDelete(option);                
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println();
        }
    }
}