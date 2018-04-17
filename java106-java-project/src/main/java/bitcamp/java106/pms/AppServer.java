// App을 서버로 만들기
package bitcamp.java106.pms;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bitcamp.java106.pms.context.ApplicationContext;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;

public class AppServer {
    
    ApplicationContext iocContainer;
    
    AppServer() throws Exception {
        init();
    }
    
    // 서버에서 작업하는데 필요한 객체를 준비한다.
    void init() throws Exception {
        // @Component가 붙은 클래스의 객체를 준비한다.
        // 각각의 객체에 대해 의존 객체를 주입한다.
        iocContainer = new ApplicationContext("bitcamp.java106.pms");
    }
    
    void onQuit() {
        System.out.println("안녕히 가세요!");
        BoardDao boardDao = (BoardDao) iocContainer.getBean(BoardDao.class);
        ClassroomDao classroomDao = (ClassroomDao) iocContainer.getBean(ClassroomDao.class);
        MemberDao memberDao = (MemberDao) iocContainer.getBean(MemberDao.class);
        TaskDao taskDao = (TaskDao) iocContainer.getBean(TaskDao.class);
        TeamDao teamDao = (TeamDao) iocContainer.getBean(TeamDao.class);
        TeamMemberDao teamMemberDao = (TeamMemberDao) iocContainer.getBean(TeamMemberDao.class);
        
        // 각각의 데이터 저장에 대해 예외 처리를 분리해야 한다.
        // 그래야만 예외가 발생하더라도 다른 데이터 저장은 정상적으로 수행할 것이다.
        try {boardDao.save();} 
        catch (Exception e) { System.out.println("게시물 데이터 저장 중 오류 발생!");}
        
        try {classroomDao.save();} 
        catch (Exception e) { System.out.println("수업 데이터 저장 중 오류 발생!");}
        
        try {memberDao.save();} 
        catch (Exception e) { System.out.println("회원 데이터 저장 중 오류 발생!");}
        
        try {taskDao.save();} 
        catch (Exception e) { System.out.println("작업 데이터 저장 중 오류 발생!");}
            
        try {teamDao.save();} 
        catch (Exception e) { System.out.println("팀 데이터 저장 중 오류 발생!");}    
        
        try {teamMemberDao.save();} 
        catch (Exception e) { System.out.println("팀멤버 데이터 저장 중 오류 발생!");}
    }

    void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }
    
    void service() throws Exception {
        // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888);
        
        while (true) {
            // 대기열에서 기다리고 있는 클라이언트 중에서 먼저 연결된 클라이언트를 꺼낸다. 
            Socket socket = serverSocket.accept();
            
            // 클라이언트 요청을 처리한다.
            processRequest(socket);
        }
    }
    
    void processRequest(Socket socket) {
        try (
            Socket socket2 = socket;
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())) {
            
            // 클라이언트가 보낸 데이터에서 명령어와 데이터를 분리한다.
            // 수신 데이터 예) /board/add?title=aaa&content=bbb
            String[] arr = in.nextLine().split("\\?");
            
            String path = arr[0]; // 예) /board/add
            
            
            
            if (arr.length > 1) {
                
            }
            
            
        } catch (Exception e) {
            
        }
    }
    
    private Map<String,String> toParamMap(String queryString) {
        // 데이터는 key와 value로 분리하여 맵에 저장한다.
        
        // queryString 예) title=aaa&content=bbb
        HashMap<String,String> paramMap = new HashMap<>();
        String[] entryArr = queryString.split("&");
        
        for (String entry : entryArr) {
            String[] keyValue = entry.split("=");
            paramMap.put(keyValue[0], keyValue[1]);
        }
        return paramMap;
    }

    public static void main(String[] args) throws Exception {
        AppServer appServer = new AppServer();
        appServer.service();
        
        
        
        /*
        
        
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
                try {
                    Controller controller = (Controller) iocContainer.getBean(menu);
                    
                    if (controller != null) {
                        controller.service(menu, option);
                    } else {
                        System.out.println("명령어가 올바르지 않습니다.");
                    }
                } catch (Exception e) {
                    if (keyScan.hasNextLine()) { 
                        // 키보드 입력으로 남은 잔여 데이터가 있다면 읽어서 버린다.
                        keyScan.nextLine(); 
                    }
                    System.out.println("작업 실행 중에 오류가 발생하였습니다.");
                    System.out.println("명령을 다시 실행해주세요!");
                }
            }

            System.out.println(); 
        }
        */
    }
    
    
}

//ver 28 - 서버 만들기






