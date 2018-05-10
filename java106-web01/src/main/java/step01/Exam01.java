// 서블릿 만들기
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// => javax.servlet.Servlet 규칙에 따라 클래스를 만들어야 한다.
// => Servlet 인터페이스
//    호출자? 즉 이 규칙에 따라 호출자하는 자는 누구냐?
//    - 서블릿 컨테이너(servlet container)이다. 
//      예) 톰캣 서버
// => 일반적으로 실행할 수 있는 자바 클래스를 만들 듯이 main() 메서드를 만들어봐야 소용없다.
// => 서블릿 컨테이너가 호출할 클래스이기 때문에, 
//    서블릿 컨테이너가 호출하는 메서드를 갖는 클래스를 만들어야 한다.
// => 서블릿 컨테이너가 어떤 메서드를 호출할지 이미 규칙으로 정의되어 있다.
//    바로 그 규칙이 Servlet 인터페이스인 것이다.
//
// 이렇게 만든 서블릿을 실행하려면 서블릿 컨테이너에 등록해야 한다.
// @WebServlet("실행할 때 사용할 이름")
// => 실행할 때 사용할 이름
//    - root 경로(/)로 시작한다.
//    - 웹브라우저에서 요청할 때 사용할 이름이다.
//    - 파일 경로처럼 중간에 슬래시(/)를 사용하여 이름을 길게 지을 수 있다.
//      예) /member/list, /team/member/list
//
// 웹 브라우저에서 이 서블릿의 실행을 요청하는 방법
// => 웹 브라우저 주소창에 다음 형식으로 URL을 입력하라!
//    http://서버주소:포트번호/웹애플리케이션이름/서블릿이름 
//    예) http://localhost:8888/bitcamp-web01/step01/exam01
//
@WebServlet("/step01/exam01")
public class Exam01 implements Servlet {
    ServletConfig config;
    
    public Exam01() {
        System.out.println("Exam01()");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 객체 생성(생성자가 호출된 후) 후 호출된다.
        // => 서블릿이 작업하는데 필요한 자원을 준비시키는 코드를 여기에 두면 된다.
        System.out.println("Exam01.init()");
        this.config = config;
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 클라이언트가 이 서블릿의 실행을 요청할 때마다 호출된다.
        // => 서블릿이 해야할 일을 처리하는 코드를 여기에 둔다.
        System.out.println("Exam01.service()");
    }
    
    @Override
    public void destroy() {
        // 웹 애플리케이션을 멈추거나 서블릿 컨테이너를 종료할 때 호출된다.
        // => init()에서 준비한 자원을 해제시키는 코드를 여기에 둔다.
        System.out.println("Exam01.destroy()");
    }
    
    @Override
    public String getServletInfo() {
        // 서버 관리자 메뉴에서 서블릿에 대한 간단한 정보를 출력하려 할 때 호출된다.
        // => 서블릿에 대한 간단한 정보를 리턴한다.
        return "Exam01 서블릿!";
    }
    
    @Override
    public ServletConfig getServletConfig() {
        // 서블릿 프로그래밍을 하면서 서블릿에 대한 설정정보가 필요할 때 호출한다.
        // => init()에서 파라미터로 받은 객체를 그대로 리턴한다.
        return this.config;
    }
}







