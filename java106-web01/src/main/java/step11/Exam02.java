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
public class Exam02 extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        ServletContext sc = this.getServletContext();
        HttpSession session = request.getSession();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("[Exam02]");
        out.printf("v1=%s\n", sc.getAttribute("v1"));
        
        // 같은 세션일 경우에는 v2 값을 가져온다.
        // 다른 세션일 경우에는 v2 값을 가져올 수 없다.
        out.printf("v2=%s\n", session.getAttribute("v2"));
        
        // 같은 요청일 경우에는 v3 값을 가져올 수 있다.
        // 같은 요청이 아닐 경우에는 v3 값을 가져올 수 없다.
        out.printf("v3=%s\n", request.getAttribute("v3"));
    }
}










