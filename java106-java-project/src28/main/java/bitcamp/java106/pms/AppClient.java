// AppServer에 접속할 클라이언트 만들기
package bitcamp.java106.pms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class AppClient {
    
    static String serverAddr;
    static int port;
    static String requestPath;
    
    public static void main(String[] args) throws Exception {
        
        Scanner keyScan = new Scanner(System.in);
        while (true) {
            System.out.print("요청> ");
            
            // 예) http://192.168.0.7:8888/board/list
            String str = keyScan.nextLine().replace("http://", "");
            
            int colonIndex = str.indexOf(':');
            int slashIndex = str.indexOf('/');
            
            if (colonIndex != -1) { // 찾았다면 
                // 예) 192.168.0.7:8888/board/list
                serverAddr = str.substring(0, colonIndex);
                port = Integer.parseInt(
                        str.substring(colonIndex + 1, slashIndex));
            } else {
                // 예) 192.168.0.7/board/list
                serverAddr = str.substring(0, slashIndex);
                port = 80;
            }
            
            requestPath = str.substring(slashIndex);
            
            if (str.equals("quit")) 
                break;
            
            send();
        }
        keyScan.close();
    }
    
    static void send() {
        try (
            Socket socket = new Socket(serverAddr, port);
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream()); ) {
        
            out.println(requestPath);
            
            while (true) {
                String str = in.nextLine();
                if (str.equals(""))
                    break;
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("서버 요청 중 오류 발생!");
            e.printStackTrace();
        }
    }
}








