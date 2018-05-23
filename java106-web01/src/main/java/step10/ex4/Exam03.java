// 세션 : 응용 - 서블릿 간에 데이터를 공유할 때 사용한다.
package step10.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex4/exam03")
public class Exam03 extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        int age = Integer.parseInt(request.getParameter("age"));
        
        // 파라미터로 받은 데이터를 다른 서블릿에서 사용할 수 있도록 세션에 보관한다.
        // => 다른 서블릿에서 이미 준비한 세션을 사용한다.
        HttpSession session = request.getSession();
        session.setAttribute("age", age); // int ----> Integer 객체 : auto-boxing
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>페이지3</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>페이지 3</h1>");
        out.println("    <form action='exam04' method='post'>");
        out.println("    전화: <input type='text' name='tel'><br>");
        out.println("    <button>다음</button>");
        out.println("    </form>");
        out.println("</body>");
        out.println("</html>");
    }
}








