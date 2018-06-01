// 외부 라이브러리에 들어있는 클래스 사용하기
package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.mylib.MessageBank;

@SuppressWarnings("serial")
@WebServlet("/step12/myservlet")
public class MyServlet extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(MessageBank.getMessage("hello"));
        out.println(MessageBank.getMessage("goodbye"));
        out.println(MessageBank.getMessage("thanks"));
        out.println(MessageBank.getMessage("title"));
        out.println(MessageBank.getMessage("content"));
        out.println(MessageBank.getMessage("password"));
        out.println(MessageBank.getMessage("ok"));
        out.println(MessageBank.getMessage("no"));
    }
}







