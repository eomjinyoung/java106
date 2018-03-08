package bitcamp.java106.pms;

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

// 3단계: 반복문 적용
public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 팀 정보를 받을 메모리 준비
        Team[] teams = new Team[100];

        for (int i = 0; i < 3; i++) {
            teams[i] = new Team();

            System.out.print("팀명? ");
            teams[i].name = keyScan.nextLine();

            System.out.print("설명? ");
            teams[i].description = keyScan.nextLine();

            System.out.print("최대인원? ");
            teams[i].maxQty = keyScan.nextInt();
            keyScan.nextLine(); 

            System.out.print("시작일? ");
            teams[i].startDate = keyScan.nextLine();

            System.out.print("종료일? ");
            teams[i].endDate = keyScan.nextLine();
        }

        System.out.println("-----------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n", 
                teams[i].name, teams[i].maxQty, 
                teams[i].startDate, teams[i].endDate);
        }
    }
}