// ApplicationContainer 구현체
package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public class DefaultApplicationContainer implements ApplicationContainer {
    
    ApplicationContext iocContainer;
    
    public DefaultApplicationContainer() throws Exception {
        // 스프링 IoC 컨테이너 객체 생성
        // => 파라미터로 넘기는 값은 스프링 IoC 컨테이너 관련 설정작업을 수행하는 클래스 정보이다.
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }
    
    @Override
    public String execute(String requestURI) {
        // 클라이언트가 보낸 데이터에서 명령어와 데이터를 분리하여 객체를 준비한다.
        ServerRequest request = new ServerRequest(requestURI);
        
        // 클라이언트 응답과 관련된 객체를 준비한다.
        StringWriter memoryWriter = new StringWriter();
        PrintWriter out = new PrintWriter(memoryWriter);
        
        ServerResponse response = new ServerResponse(out);
        
        // 클라이언트가 보낸 명령어를 처리할 컨트롤러를 찾는다.
        String path = request.getServerPath();
        Controller controller = (Controller) iocContainer.getBean(path);
        
        if (controller != null) {
            controller.service(request, response);
        } else {
            out.println("해당 명령을 처리할 수 없습니다.");
        }
        return memoryWriter.toString();
    }
}

//ver 33 - Mybatis의 SqlSessionFactory 객체 생성 및 IoC 컨테이너에 등록
//ver 32 - DataSource 객체 생성 및 IoC 컨테이너에 등록
//ver 29 - 클래스 추가
