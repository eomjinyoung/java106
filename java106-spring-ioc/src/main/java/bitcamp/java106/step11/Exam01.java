// 클래스를 이용하여 스프링 설정하기
package bitcamp.java106.step11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig01.class);
        
        BeanUtils.printBeanNames(iocContainer);
        
        System.out.println(iocContainer.getBean("car"));
    }

}





