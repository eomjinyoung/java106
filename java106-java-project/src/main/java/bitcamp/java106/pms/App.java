package bitcamp.java106.pms;

import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java106.pms.context.ApplicationContext;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.util.Console;

public class App {
    
    static ApplicationContext iocContainer;
    
    static Scanner keyScan = new Scanner(System.in);
    public static String option = null; 
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
        BoardDao boardDao = (BoardDao) iocContainer.getBean(BoardDao.class);
        ClassroomDao classroomDao = (ClassroomDao) iocContainer.getBean(ClassroomDao.class);
        MemberDao memberDao = (MemberDao) iocContainer.getBean(MemberDao.class);
        TaskDao taskDao = (TaskDao) iocContainer.getBean(TaskDao.class);
        TeamDao teamDao = (TeamDao) iocContainer.getBean(TeamDao.class);
        TeamMemberDao teamMemberDao = (TeamMemberDao) iocContainer.getBean(TeamMemberDao.class);
        try {
            boardDao.save();
            classroomDao.save();
            memberDao.save();
            taskDao.save();
            teamDao.save();
            teamMemberDao.save();
        } catch (Exception e) {
            System.out.println("게시물 데이터 저장 중 오류 발생!");
        }
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

    public static void main(String[] args) throws Exception {
        
        // 기본 객체 준비
        HashMap<String,Object> defaultBeans = new HashMap<>();
        defaultBeans.put("java.util.Scanner", keyScan);
        
        // 기본 객체와 함께 @Component가 붙은 클래스의 객체를 준비한다.
        iocContainer = new ApplicationContext(
                "bitcamp.java106.pms", defaultBeans);
        
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
            } else {
                int slashIndex = menu.lastIndexOf("/");
                String controllerKey = (slashIndex < 0) ? 
                        menu : menu.substring(0, slashIndex);
                
                Controller controller = (Controller) iocContainer.getBean(controllerKey);
                
                if (controller != null) {
                    controller.service(menu, option);
                } else {
                    System.out.println("명령어가 올바르지 않습니다.");
                }
            }

            System.out.println(); 
        }
    }
}

//ver 24 - 파일 저장 기능 호출. 멤버 및 팀 데이터를 준비하는 메서드 제거.
//ver 17 - Task 관리 기능 추가
// ver 15 - TeamDao와 MemberDao 객체 생성. 
//          팀 멤버를 다루는 메뉴 추가.






