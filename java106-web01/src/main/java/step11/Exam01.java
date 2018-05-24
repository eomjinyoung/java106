// 저장소 사용
package step11;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step11/exam01")
public class Exam01 extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        ServletContext sc = this.getServletContext();
        HttpSession session = request.getSession();
        
        sc.setAttribute("v1", "aaa");
        session.setAttribute("v2", "bbb");
        request.setAttribute("v3", "ccc");
        
        request.getRequestDispatcher("/step11/exam02").forward(request, response);
    }
}










