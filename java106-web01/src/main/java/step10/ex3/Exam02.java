// 세션 : 값 꺼내기
package step10.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex3/exam02")
public class Exam02 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 1) 기존 세션 가져오기
        // => 주의! 
        //    이 서블릿을 처음으로 실행하면 서버에 세션아이디를 보내지 않기 때문에 
        //    서버 입장에서는 세션이 없는 것으로 간주하고 새로 세션을 만든다.
        // => 세션이 없으면 새로 만든다. 
        //    세션이 없다는 뜻은 웹브라우저가 세션 아이디를 알려주지 않았다는 뜻이다.
        HttpSession session = request.getSession();
        
        // 2) 세션에 저장된 값 꺼내기
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("s1=%s\n", session.getAttribute("s1"));
        out.printf("s2=%s\n", session.getAttribute("s2"));
        out.printf("s3=%s\n", session.getAttribute("s3"));
    }
}








