// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;

@Component("hi")
public class HiController implements Controller {
    Scanner keyScan;
    
    public HiController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        System.out.printf("'%s'님 안녕하세요!", option);
    }

}

//ver 26 - HiController 클래스를 한 개의 명령을 처리하는 클래스로 변경.
//ver 23 - 유지보수 테스트를 위해 임시로 만듦.