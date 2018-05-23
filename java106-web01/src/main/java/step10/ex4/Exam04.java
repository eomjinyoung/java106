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
@WebServlet("/step10/ex4/exam04")
public class Exam04 extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        //세션에 보관된 '이름', '나이' 값을 가져온다.
        HttpSession session = request.getSession();
        
        String name = (String)session.getAttribute("name");
        int age = (int)session.getAttribute("age"); // auto-unboxing
        
        // 파라미터로 받은 데이터는 그대로 getParameter()로 꺼낸다.
        String tel = request.getParameter("tel");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>확인</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>확인</h1>");
        out.printf("이름: %s<br>\n", name);
        out.printf("나이: %d<br>\n", age);
        out.printf("전화: %s<br>\n", tel);
        out.println("</body>");
        out.println("</html>");
    }
}








