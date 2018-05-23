// 세션 : 응용 - 서블릿 간에 데이터를 공유할 때 사용한다.
package step10.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex4/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>페이지1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>페이지 1</h1>");
        out.println("    <form action='exam02' method='post'>");
        out.println("    이름: <input type='text' name='name'><br>");
        out.println("    <button>다음</button>");
        out.println("    </form>");
        out.println("</body>");
        out.println("</html>");
    }
}








