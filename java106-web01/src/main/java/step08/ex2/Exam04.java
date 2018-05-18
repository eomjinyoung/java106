// 실행 위임 하는 방법 - forward
package step08.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex2/exam04")
public class Exam04 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        if (!op.equals("/")) {
            // + 연산자가 아니라면 다음 서블릿에게 실행을 위임한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher(
                    "/step08/ex2/exam05");
            요청배달자.forward(request, response);
            return;
        }
        
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>계산결과</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>exam04</h1>");
        out.printf("<p>%d / %d = %d</p>\n", a, b, (a / b));
        out.println("</body>");
        out.println("</html>");
    }
}







