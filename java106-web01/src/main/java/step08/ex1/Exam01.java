// 자동으로 페이지를 이동하는 방법 - Refresh(HTML 페이지에 삽입)
package step08.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex1/exam01")
public class Exam01 extends HttpServlet {
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
        
        // 다음과 같이 HTML 페이지에 meta 태그를 이용하여
        // refresh를 설정할 수 있다.
        // meta 태그 속성: 
        //     http-equiv="Refresh"
        //     content="타임아웃시간(초);url=요청할 URL"
        // 용도:
        //     작업 결과를 출력한 후에 지정된 페이지로 이동시키고 싶을 때 사용한다.
        // 
        out.println("  <meta http-equiv='Refresh' content='3;url=http://www.daum.net'>");
        
        out.println("  <title>exam01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <h1>exam01</h1>");
        out.println("  <p>3초 후에 카카오 홈페이지를 다시 요청한다.<br>");
        out.println("     일종의 페이지를 자동으로 이동하는 효과가 있다.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}







