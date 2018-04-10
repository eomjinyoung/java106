// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;

@Component("calc")
public class CalcController implements Controller {
    Scanner keyScan;
    
    public CalcController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        System.out.print("식을 입력하세요? ");
        String[] arr = keyScan.nextLine().split(" ");
        if (arr.length != 3) {
            System.out.println("입력 형식 예) 3 + 2");
            return;
        }
        
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        int result = 0;
        
        switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        default: 
            System.out.printf("%s 연산은 지원하지 않습니다.\n", op);
            return;
        }
        
        System.out.printf("%d %s %d = %d\n", a, op, b, result);
    }

}

//ver 26 - 클래스 추가