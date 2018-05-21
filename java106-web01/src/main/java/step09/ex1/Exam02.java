// 서블릿 실행 
package step09.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step09/ex1/exam02")
public class Exam02 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>exam02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>exam02 실행!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        // 콘솔 창에 서블릿이 실행되었음을 표시하기 위해 출력한다.
        // => 필터의 실행과 서블릿의 실행 순서를 확인하기 위함이다.
        System.out.println("/step09/ex1/exam02 실행!");
    }
}







