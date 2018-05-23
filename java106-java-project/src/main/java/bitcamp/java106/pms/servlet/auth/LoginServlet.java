// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>로그인</h1>");
        out.println("<form action='login' method='post'>");
        out.println("<table border='1'>");
        out.println("<tr><th>아이디</th>");
        out.println("    <td><input type='text' name='id'></td></tr>");
        out.println("<tr><th>암호</th>");
        out.println("    <td><input type='password' name='password'></td></tr>");
        out.println("</table>");
        out.println("<button>로그인</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
    }
}










