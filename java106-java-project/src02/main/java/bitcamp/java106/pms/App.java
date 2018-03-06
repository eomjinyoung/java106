package bitcamp.java106.pms;

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("팀명? ");
        String teamName = keyScan.nextLine();

        System.out.print("설명? ");
        String description = keyScan.nextLine();

        System.out.print("최대인원? ");
        int maxQty = keyScan.nextInt();
        keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드를 읽는다.
                            // 읽고 난 뒤에 아무것도 안하기 때문에 
                            // 일종의 줄바꿈 코드를 제거하는 효과가 있다.

        System.out.print("시작일? ");
        String startDate = keyScan.nextLine();

        System.out.print("종료일? ");
        String endDate = keyScan.nextLine();

        System.out.println("-----------------------------");
        System.out.print("팀명: ");
        System.out.println(teamName);
        System.out.println("설명: ");
        System.out.println(description);
        System.out.print("최대인원: ");
        System.out.println(maxQty);
        System.out.print("일자: ");
        System.out.print(startDate);
        System.out.print(" ~ ");
        System.out.println(endDate);
    }
}