// 라이브러리 개발자는 웹 애플리케이션이 시작될 때 
// 보고를 받고 싶다.
// 왜? 
// => 필요하다면 라이브러리를 사용하기 전에 초기화시키려고 한다.
// 방법
// => ServletContainerInitializer를 구현하고, 
//    클래스에 대한 정보를 /META-INF/serivces 폴더에 등록해 두면 된다.
//    그러면 서블릿 컨테이너가 찾아 호출할 것이다.
package bitcamp.mylib;

import java.lang.reflect.Constructor;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

// 서블릿 컨테이너에게 다음 인터페이스를 구현한 클래스를 찾아 
// onStartup() 메서드를 호출할 때 그 클래스 정보를 달라고 지정한다.
@HandlesTypes(MessageInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(
            Set<Class<?>> messageInitializers, 
            ServletContext ctx) throws ServletException {
        // 서블릿 컨테이너가 웹 애플리케이션을 시작할 때 
        // 나의 라이브러리에 대해 이 메서드를 호출해줄 것이다.
        System.out.println("------------------------------------------------");
        System.out.println("===> MyServletContainerInitializer.onStartup()");
        
        if (messageInitializers != null) {
            for (Class<?> clazz : messageInitializers) {
                try {
                    Constructor<?> constructor = clazz.getConstructor();
                    MessageInitializer obj = 
                            (MessageInitializer)constructor.newInstance();
                    obj.onStartup(MessageBank.messageMap);
                    
                } catch (Exception e) {}
            }
        }
        System.out.println("------------------------------------------------");
    }

}
