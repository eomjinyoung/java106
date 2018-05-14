// 같은 이름의 파라미터 값이 여러 개일 경우
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam06")
public class Exam06 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // GET 요청의 데이터를 꺼낼 경우에는 다음 코드는 의미가 없다.
        // 그러나 POST 요청의 데이터를 꺼낼 경우를 대비해서 그냥 둔다.
        request.setCharacterEncoding("UTF-8");
        
        String[] names = request.getParameterValues("name");
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        for (String name : names) {
            out.printf("이름=%s\n", name);
        }
    }
}






