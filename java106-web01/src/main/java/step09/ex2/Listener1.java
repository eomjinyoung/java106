// 리스너 = 이벤트 핸들러 : 특정 상태가 되었을 때 실행되는 객체
//                    
package step09.ex2;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 리스너
// => 특정 상태가 되었을 때 작업을 수행하는 객체
// => 특정 상태에 도달했을 때의 시각 또는 걸린 시간을 기록하여 
//    서버의 실행 상태를 보여주는 모니터링 시스템을 만들 때 유용하다.
// => 예) 애플리케이션 성능 관리(=모니터링) 시스템(Application Performance Management System; APM)
//
// 서블릿 컨테이너에서 발생하는 이벤트(event, 사건, 상태)
// 1) 서블릿 컨테이너의 시작/종료 이벤트
// 2) 요청이 시작/종료 이벤트
// 3) ServletRequest에 값을 저장하고 제거하는 이벤트
// 4) HttpSession 객체가 생성되고 제거되는 이벤트
// 5) HttpSession에 값을 저장하고 제거하는 이벤트
// 등
//
// 리스너 만들기 
// => 이벤트가 발생했을 때 어떤 메서드를 호출할지 그 규칙이 서블릿 기술에 명세되어 있다.
// => 특정 이벤트가 발생했을 때 어떤 작업을 처리하고 싶다면,
//    그 이벤트에 대한 규칙에 따라 클래스를 정의하라!
// 
// 예: 서블릿 컨테이너가 시작되거나 종료될 때 그 시간을 출력하고 싶다.
// => 서블릿 컨테이너가 시작되거나 종료될 때 호출하는 메서드를 정의한 규칙을 구현한다!
// 
// 리스너 배치
// => 서블릿 컨테이너에게 이벤트를 처리할 리스너를 등록해야만 동작한다.
// => 배치하는 방법
//    1) 애노테이션을 사용하여 배치
//       @WebListener
//    2) web.xml 파일에 배치 정보 설정
//       <listener>
//           <listener-class>step09.ex2.Listener1</listener-class>
//       </listener>
//
@WebListener
public class Listener1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 서블릿 컨테이너가 시작될 때 호출된다.
        // => 여기에는 모든 서블릿들이 사용할 도구를 준비시키는 코드를 둔다.
        System.out.printf("Listener1.contextInitialized() - %s\n", new Date());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 서블릿 컨테이너가 종료될 때 호출된다.
        // => 여기에는 서블릿 컨테이너가 시작될 때 준비한 도구나 자원을 해제시키는 코드를 둔다.
        System.out.printf("Listener1.contextDestroyed() - %s\n", new Date());
    }
}








