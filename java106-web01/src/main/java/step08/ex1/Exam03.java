// 자동으로 페이지를 이동하는 방법 - Redirect
package step08.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex1/exam03")
public class Exam03 extends HttpServlet {
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
        out.println("  <title>exam03</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <h1>exam03</h1>");
        out.println("  <p>이 내용이 화면에 출력될까요? 확인해 보세요!</p>");
        out.println("</body>");
        out.println("</html>");
        
        // 리다이렉트(redirect)
        // => 클라이언트 요청을 다른 서블릿으로 돌리고 싶을 때 사용한다.
        // => 이 방식도 일종의 페이지 자동 이동 효과를 제공한다.
        // => 웹브라우저는 서버가 보낸 URL로 다시 요청한다.
        // 
        // refresh vs redirect
        // - redirect는 클라이언트로 내용을 보내지 않는다.
        // - 따라서 이동하기 전에 화면에 뭔가를 출력할 수 없다.
        // - 즉 다음 메서드를 호출하는 순간 이전에 out.println() 등으로 
        //   출력했던 내용이 버려진다.
        // - 어? 이미 클라이언트로 데이터를 보냈는데 어떻게 그 데이터버릴 수 있나요?
        //   헐... 내가 전에 얘기 했다. 
        //   출력문을 호출하면 즉시 클라이언트로 보내는 것이 아니라,
        //   버퍼에 보관된다고 분명히 얘기했다.
        //   버퍼에 보관되기 때문에 출력하기 전에 버릴 수 있는 것이다.
        // - 다음 메서드를 호출하기 전에 출력한 내용이 버퍼를 모두 채웠다면 어떻게 되나요?
        //   버퍼가 차는 순간 즉시 자동으로 클라이언트로 버퍼의 내용물을 내보내기 때문에 
        //   redirect를 할 수 없다.
        //   그것을 떠나서 redirect는 클라이언트에게 뭔가를 출력하지 않고 
        //   다른 URL로 이동하라는 명령만 내릴 때 사용한다고 했다.
        //   그런데도 불구하고 redirect를 사용할거면서 출력하는 것은 뭐냐?
        //   출력하고 싶으면 refresh를 써야지,
        //   redirect를 사용하기로 해놓고 출력하는 것은 뭐냐?
        //   그러니까 redirect를 사용하면서 버퍼가 찰 것을 걱정하지 말라!
        //   
        response.sendRedirect("http://www.daum.net"); 
        
        // redirect의 HTTP 응답 프로토콜
        /*
        HTTP/1.1 302
        Location: http://www.daum.net
        Content-Type: text/html;charset=UTF-8
        Content-Length: 0
        Date: Fri, 18 May 2018 02:12:21 GMT
        
        (내용물 없음!)
        */
    }
}







