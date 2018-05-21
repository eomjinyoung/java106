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
@WebServlet("/step08/ex3/header")
public class Header extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        out.println("<div id='header'>");
        out.println("    <span>비트캠프 자바106기</span>");
        out.println("</div>");
    }
}







