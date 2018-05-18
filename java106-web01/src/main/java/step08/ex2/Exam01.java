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
@WebServlet("/step08/ex2/calculator")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        if (!op.equals("+")) {
            // + 연산자가 아니라면 다음 서블릿에게 실행을 위임한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher(
                    "/step08/ex2/exam02");
            요청배달자.forward(request, response);
            return;
        }
        
        // 주의!
        // => + 문자를 다음과 같이 URL에 파라미터 값으로 보내면 
        //    서버에서는 공백 문자로 간주한다.
        //    예) http://localhost:8888/java106-web01/step08/ex2/exam01?op=+&a=20&b=15
        // => 즉 URL에서 '+' 문자는 공백을 표시할 때 사용하는 특수 기호이다.
        // => URL 파라미터 값으로 '+' 문자를 서버에 보내고 싶다면 URL 인코딩 값을 보내라 
        //    '+' ===> %2B (%2b)
        //
        
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
        out.println("<h1>exam01</h1>");
        out.printf("<p>%d + %d = %d</p>\n", a, b, (a + b));
        out.println("</body>");
        out.println("</html>");
    }
}







