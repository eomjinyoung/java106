// 저장소 사용
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step11/exam02")
public class Exam03 extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        ServletContext sc = this.getServletContext();
        HttpSession session = request.getSession();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("v1=%s\n", sc.getAttribute("v1"));
        out.printf("v2=%s\n", session.getAttribute("v2"));
        out.printf("v3=%s\n", request.getAttribute("v3"));
    }
}










