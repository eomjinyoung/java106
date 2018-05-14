// GET 요청과 POST 요청을 구분하기 - HttpServlet 클래스의 doXxx() 사용하기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/exam04")
public class Exam04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/java106-web01/step04/exam04_test.html
    
    // 서블릿 컨테이너는 service(ServletRequest, ServletResponse)를 호출하면 
    // 다음 절차를 거치면서 메서드가 호출된다.
    // service(ServletRequest, ServletResponse)
    //     => service(HttpServletRequest,HttpServletResponse) 
    //         => doGet(HttpServletRequest,HttpServletResponse)
    //         => doPost(HttpServletRequest,HttpServletResponse)
    //         => doHead(HttpServletRequest,HttpServletResponse)
    //            ...
    // 따라서, GET 요청을 처리하고 싶다면 service()를 재정의하는 대신에 doGet()을 재정의하면 된다.
    // POST 요청을 처리하고 싶다면 마찬가지고 service() 대신에 doPost()를 재정의하면 된다.
    //    
    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 GET 요청을 하면 이 메서드가 최종적으로 호출된다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("doGet() 호출됨!");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
    
    public void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 POST 요청을 하면 이 메서드가 최종적으로 호출된다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("doPost() 호출됨!");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
}

