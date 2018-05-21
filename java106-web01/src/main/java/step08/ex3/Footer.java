// 다른 서블릿의 작업을 포함하기 - include
package step08.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex3/footer")
public class Footer extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        out.println("<div id='footer'>");
        out.println("    <p>Copyright &copy; 2018 자바106기"
                + "<address>서울시 서초구 교육센터</address></p>");
        out.println("</div>");
    }
}







