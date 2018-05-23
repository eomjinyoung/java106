// 쿠키 : 유효기간 설정하기
package step10.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex2/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        Cookie cookie1 = new Cookie("c1", "aaa");
        cookie1.setMaxAge(20); // 유지 시간(초)을 설정한다.
        // 유효기간을 설정하면 웹브라우저를 닫아도, 컴퓨터를 종료해도 유지된다.
        // 왜? 파일시스템(HDD 등)에 보관하기 때문에 컴퓨터를 꺼도 유지된다.
        // 당연히 유효기간이 지나면 웹브라우저는 웹서버에게 보내지 않고 해당 쿠키를 제거한다.
        
        Cookie cookie2 = new Cookie("c2", "bbb");
        cookie2.setMaxAge(40); // 30초 동안만 유효하다. 
        
        Cookie cookie3 = new Cookie("c3", "ccc");
        // 유효기간을 설정하지 않으면 웹브라우저를 실행하는 동안만 유효하다.
        // 웹브라우저를 닫으면 유효기간이 설정되지 않은 쿠키는 자동으로 삭제된다.
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
// 쿠키를 클라이언트로 보내는 HTTP 프로토콜?
//        HTTP/1.1 200
//        Set-Cookie: c1=aaa; Max-Age=10; Expires=Wed, 23-May-2018 01:54:57 GMT
//        Set-Cookie: c2=bbb; Max-Age=30; Expires=Wed, 23-May-2018 01:55:17 GMT
//        Set-Cookie: c3=ccc
//        Content-Type: text/plain;charset=UTF-8
//        Content-Length: 27
//        Date: Wed, 23 May 2018 01:54:47 GMT
//        (빈 줄)
//        내용...
    }
}








