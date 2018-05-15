// HTML 출력 - 폼 화면 출력과 입력 데이터 처리 
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // GET 요청을 받으면 입력폼을 제공한다.
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>입력폼</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>성적입력</h1>");
        out.println("    <form action='exam02' method='post'>");
        out.println("    이름: <input type='text' name='name'><br>");
        out.println("    국어: <input type='text' name='kor'><br>");
        out.println("    영어: <input type='text' name='eng'><br>");
        out.println("    수학: <input type='text' name='math'><br>");
        out.println("    <button>계산</button>");
        out.println("    </form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // POST 요청을 받으면 이 메서드가 호출된다.
        // 이 메서드는 입력 값을 계산하여 결과를 출력한다.
        
        // POST 요청으로 한글 값이 전송될 때는 한글이 깨지지 않게 문자표를 알려줘야 한다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int math = Integer.parseInt(request.getParameter("math"));
        int sum = kor + eng + math;
        float aver = sum / 3f;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>결과</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>결과</h1>");
        out.printf("    이름: %s<br>\n", name);
        out.printf("    국어: %d<br>\n", kor);
        out.printf("    영어: %d<br>\n", eng);
        out.printf("    수학: %d<br>\n", math);
        out.printf("    합계: %d<br>\n", sum);
        out.printf("    평균: %.1f<br>\n", aver);
        out.println("</body>");
        out.println("</html>");
        
    }
}









