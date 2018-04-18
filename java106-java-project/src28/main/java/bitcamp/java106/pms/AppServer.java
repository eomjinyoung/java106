// App을 서버로 만들기
package bitcamp.java106.pms;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import bitcamp.java106.pms.context.ApplicationContext;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

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
        System.out.println("서버 실행 했음!");
        
        while (true) {
            // 대기열에서 기다리고 있는 클라이언트 중에서 먼저 연결된 클라이언트를 꺼낸다. 
            Socket socket = serverSocket.accept();
            
            // 클라이언트 요청을 처리한다.
            processRequest(socket);
        }
    }
    
    void processRequest(Socket socket) {
        
        PrintWriter out = null;
        Scanner in = null;
        
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
            
            // 클라이언트가 보낸 데이터에서 명령어와 데이터를 분리하여 객체를 준비한다.
            ServerRequest request = new ServerRequest(in.nextLine());
            
            // 클라이언트 응답과 관련된 객체를 준비한다.
            ServerResponse response = new ServerResponse(out);
            
            // 클라이언트가 보낸 명령어를 처리할 컨트롤러를 찾는다.
            String path = request.getServerPath();
            Controller controller = (Controller) iocContainer.getBean(path);
            
            if (controller != null) {
                controller.service(request, response);
            } else {
                out.println("해당 명령을 처리할 수 없습니다.");
            }
            out.println(); // 응답의 끝을 표시하기 위해 빈줄을 클라이언트로 보낸다.
            
        } catch (Exception e) {
            out.println("서버 오류!");
            e.printStackTrace(out);
            out.println();
        } finally {
            out.close();
            in.close();
            try {socket.close();} catch (Exception e) {}
        }
    }

    public static void main(String[] args) throws Exception {
        AppServer appServer = new AppServer();
        appServer.service();
    }
}

//ver 28 - 서버 만들기






