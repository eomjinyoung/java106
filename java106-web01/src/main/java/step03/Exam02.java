// 한글 깨짐 처리
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // 출력할 콘텐츠의 타입(MIME type)이 무엇이고, 
        // 어떤 문자코드표(character set)를 사용하여 변환할 것인지 지정한다. 
        response.setContentType("text/plain; charset=UTF-8");
        
        // 출력스트림을 꺼낼 때 
        // 스트림에서 사용할 문자표를 지정하지 않으면,
        // 기본으로 ISO-8859-1 문자코드표를 사용하여 문자열을 출력한다.
        // 즉 다음과 같이 클라이언트로 문자열을 보낸다.
        //      String 객체(UTF-16) ==> ISO-8859-1 
        // 즉 String 객체에 들어있는 문자열을 ISO-8859-1 코드표에 따라 
        // 변환하여 클라이언트로 보낸다.
        PrintWriter out = response.getWriter();
        out.println("Hello!");
        
        // 문제는 한글이다.
        // 한글은 ISO-8859-1에 코드가 명시되어 있지 않다.
        // 따라서 한글은 ISO-8859-1 코드 값으로 바꿀 수 없기 때문에 
        // 바꾸지 못했다는 의미로 '?' 문자를 대신 보낸다.
        out.println("안녕하세요!");
        
        // 해결책?
        // => ServletResponse 객체서 출력스트림을 꺼내기 전에 
        //    어떤 문자코드표를 사용할 것인지 설정해야 한다.
        // => 출력하기 전이 아니라 출력스트림을 꺼내기 전이다!
    }
}

// MIME(Multi-purpose Internet Mail Extension) type
// => 원래는 메일을 보낼 때 콘텐츠의 타입을 알려주기 위해 만들었다.
// => 그러나 지금은 메일 뿐만 아니라 다방면에서 콘텐츠의 타입을 지정하는 용도로 사용하고 있다.
// => 예) text/html, text/plain, application/excel 등
// 






