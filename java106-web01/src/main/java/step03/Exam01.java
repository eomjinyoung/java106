// 클라이언트로 출력하기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam01")
public class Exam01 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        // 클라이언트에게 응답하는 작업과 관련된 도구들이 ServletResponse 객체에 보관되어 있다.
        // 특히 클라이언트에게 데이터를 출력할 때 사용할 출력 스트림 객체도 이 객체에 들어 있다.
        // 이 객체에 들어있는 출력 스트림을 사용하여 데이터를 출력하면,
        // 클라이언트로 보내질 것이다.
        // 주의!
        // => 출력 스트림으로 출력한 데이터는 내부 버퍼에 보관되어 있다.
        // => 바로 클라이언트로 보내는 것이 아니다.
        // => 왜?
        //    HTTP 프로토콜에 맞춰서 응답해야 하기 때문이다.
        //
        // 1) 출력 스트림을 얻는다.
        PrintWriter out = response.getWriter();
        
        // 2) 출력 스트림을 이용하여 데이터를 출력한다.
        // => service() 메서드가 실행되는 동안 출력하는 데이터는 모두 버퍼로 보내진다.
        // => service() 메서드 호출이 끝나면 비로서 버퍼에 보관된 데이터를 
        //    HTTP 프로토콜에 맞춰서 서버에 보낸다.
        out.println("Hello!");
        out.println("안녕하세요!");
    }
}








