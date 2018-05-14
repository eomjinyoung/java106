// GET 요청과 POST 요청 구분하기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step04/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/java106-web01/step04/exam01_test.html 
    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 보낸 값을 꺼낼 때는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // UTF-16 ==> UTF-8
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
    }
}

// HTTP 프로토콜 - GET 요청
// - request-URI에 데이터를 포함해서 보낸다.
//       URL?파라미터명=값&파라미터명=값&파라미터명=값...
//   예) /java106-web01/step04/exam01?name=bbb&age=30
// 
/*
GET /java106-web01/step04/exam01?name=bbb&age=30 HTTP/1.1   <== request-line
Host: localhost:8888   <=== header(general/request/entity)
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,...
Referer: http://localhost:8888/java106-web01/step04/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
(빈줄)   <== empty line. 보내는 데이터의 끝을 알림. 
*/

//HTTP 프로토콜 - POST 요청
//- message-body(entity-body)에 데이터를 포함해서 보낸다.
//- post 요청을 할 때는 보내는 데이터의 정보를 추가한다.
//  즉 Content-Length 와 Content-Type 헤더를 추가해서 보낸다.
//
/*
POST /java106-web01/step04/exam01 HTTP/1.1     <== request-line
Host: localhost:8888    <== header(general/request/entity)
Connection: keep-alive
Content-Length: 32      <== post 요청할 때만 보내는 헤더 값. 빈 줄 다음에 읽어야 할 바이트의 수.
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded    <== post 요청할 때만 보내는 헤더 값
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*...
Referer: http://localhost:8888/java106-web01/step04/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
(빈 줄)  <== empty line 
name=AB%EA%B0%80%EA%B0%81&age=40    <== post 요청은 빈 줄 다음에 데이터를 보낸다.  
*/







