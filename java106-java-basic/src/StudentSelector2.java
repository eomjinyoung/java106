import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector2 {

    public static void main(String[] args) throws Exception {
        String[] students = {
                "1", "2", "2", "1"
            };
        /*
        String[] students = {
            "경명수", "김관희", "김기남", "김복진",
            "김소영", "문선민", "박서경", "박현기",
            "성현동", "이동현", "이상경", "이왕로",
            "장하은", "차진호", "최보람", "한돈희", "홍정호"
        };
        */
        
        ArrayList<String> list = new ArrayList<>();
        for (String name : students) {
            list.add(name);
        }
        
        Scanner keyScan = new Scanner(System.in);
        int selectedNo = 0;
        while (list.size() > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.print(".");
                Thread.currentThread().sleep(500);
            }
            selectedNo = (int)(Math.random() * list.size());
            System.out.println(list.remove(selectedNo));
            keyScan.nextLine();
        }
    }

}



