// 세션 : 생성
package step10.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex3/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 1) 세션 생성
        HttpSession session = request.getSession();
        
        // 2) 세션에 값 저장
        // => 서버쪽에 저장하는 것이기 때문에 어떤 값이라도 저장할 수 있다.
        //    즉 문자열 외에 숫자, 객체 모두 저장할 수 있다.
        session.setAttribute("s1", "aaa");
        session.setAttribute("s2", 200); // auto-boxing을 수행하여 객체로 변환한 후 저장된다.
        session.setAttribute("s3", new Date());
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("세션을 만들고 세션에 값을 저장했습니다.");
        out.println("그리고 세션의 아이디를 쿠키로 보냈습니다.");
        
    }
}








