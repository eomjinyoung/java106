// 서블릿 만들기 6 - 자바에서 제공하는 HttpServlet 상속 받아 만들기
package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step01/exam06")
public class Exam06 extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    // 클라이언트가 실행을 요청하면 
    // 명령어에 따라 적절한 메시지를 출력하도록 상속 받은 메서드를 재정의하자!
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("GET 요청하셨네요.^^");
    }
}







