// 서블릿을 서블릿 컨테이너에 배치하기 : XML 파일에 설정하는 방법
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 애노테이션이 등장하기 전에는 XML 파일에 서블릿 클래스 정보를 등록하였다.
//   /WEB-INF/web.xml
// web.xml은 웹 애플리케이션의 배치 정보를 담고 있는 파일이다.
// 그래서 "Deployment Descriptor File"이라고 부른다.
// 줄여서 DD File 이라고 부르기도 한다.
// 
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("step02.Exam02.sevice()");
    }
}







