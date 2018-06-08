package bitcamp.java106.step13.ex2;

import org.springframework.stereotype.Component;

@Component 
public class Z {
    public Z() {
        System.out.println("Z 객체 생성됨");
    }
    public void m2() {
        System.out.println("Z.m2()");
    }
}
