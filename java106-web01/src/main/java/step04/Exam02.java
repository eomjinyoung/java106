// GET 요청과 POST 요청을 구분하기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/step04/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/java106-web01/step04/exam02_test.html 
    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 보낸 값을 꺼낼 때는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // 클라이언트가 요청한 방식을 알아내기
        // => 요청 방식은 HTTP 프로토콜에 대한 내용이다.
        // => ServletRequest에는 HTTP 프로토콜에 대한 내용을 다룰 수 있는 기능이 없다.
        // => 해결책? 
        //    서블릿 컨테이너가 service()를 호출할 때 넘겨준 파라미터의 
        //    원래 타입으로 변환하라!
        // => 서블릿 컨테이너는 service()를 호출할 때 HTTP 정보를 다룰 수 있는 
        //    HttpServletRequest와 HttpServletResponse를 넘겼다. 
        // => 따라서 이 타입으로 형변환하면 된다.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // ServletRequest에는 "HTTP method"를 알아내는 메서드가 없다.
        // String method = request.getMethod();
        
        // 원래의 타입인 HttpServletRequest에는 "HTTP method"를 알아내는 메서드가 있다. 
        String method = httpRequest.getMethod();
        
        // UTF-16 ==> UTF-8
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("요청 방식=%s\n", method);
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
        
    }
}

