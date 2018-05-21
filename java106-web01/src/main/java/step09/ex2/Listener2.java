// ServletRequestListener: 요청이 들어오고 응답이 완료되었을 때 발생하는 이벤트 처리
//                    
package step09.ex2;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class Listener2 implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 요청이 들어올 때 호출된다. 필터가 수행되기 전에 호출된다. 
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        System.out.println("Listener2.requestInitialized()");
        System.out.printf("[%s] %s\n", 
                request.getRemoteAddr(),
                request.getServletPath());
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 필터까지 모두 수행한 후 응답을 완료했을 때 호출된다.
        System.out.println("Listener2.requestDestroyed()");
    }
}








