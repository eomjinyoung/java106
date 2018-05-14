// 파일 업로드 - 멀티파트 파라미터 값 추출하기
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 테스트 방법:
        // http://localhost:8888/java106-web01/step05/exam02_test.html
        
        // 멀티파트로 전송된 POST 요청 데이터를 추출하려면 일반적인 방법으로는 안된다.
        // apache.org 사이트의 라이브러리를 사용하여 처리해 보자!
        // 1) 의존 라이브러리 정보 알아내기
        //    mvnrepository.com 에서 "apache fileupload" 검색 
        // 2) build.gradle 에 의존 라이브러리 정보 추가
        // 3) "gradle eclipse" 실행하여 이클립스 설정 파일 갱신
        // 4) 이클립스 IDE에서 프로젝트 갱신
        
        // apache-fileupload 라이브러리를 사용하여 클라이언트가 보낸 멀티파트 데이터를 추출해보자! 
        
        // 출력할 때 UTF-16 ===> UTF-8로 제대로 바꾸기 위해
        // 출력스트림을 얻기 전에 알려줘야 한다.
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.printf("이름=%s\n", name);
        //out.printf("나이=%s\n", age);
        //out.printf("사진=%s\n", photo);
        
        
    }
}







