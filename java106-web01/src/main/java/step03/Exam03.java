// 클라이언트가 보낸 데이터(요청 파라미터;request parameter)를 읽기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam03")
public class Exam03 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // HTTP 요청과 관련된 도구는 ServletRequest에 들어있다.
        // 특히 클라이언트가 보낸 데이터를 꺼낼 때는 getParameter("key")를 사용하라!
        // => 리턴 값은 String이기 때문에 다른 타입으로 바꾸려면 적절한 형변환을 수행하라!
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("이름=%s\n", name);
        out.printf("나이=%d\n", age);
    }
}






