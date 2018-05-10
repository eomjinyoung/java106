// 서블릿 만들기 3 - 추상 클래스를 상속 받아서 Servlet 인터페이스를 간접적으로 구현하기.
package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// => javax.servlet.Servlet 인터페이스를 직접 구현하는 것 보다
//    미리 구현한 클래스를 상속 받아서 
//    필요한 메서드만 구현하거나 재정의하는 것이 편하다!
// => 그래서 이미 자바에서는 GenericServlet 이름을 가진 클래스를 제공하고 있다.
// => 있는데 왜 만든 겁니다?
//    - 
//
@WebServlet("/step01/exam03")
public class Exam03 extends javax.servlet.GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Exam02.service()");
    }
}







