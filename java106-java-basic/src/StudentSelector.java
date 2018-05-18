
public class StudentSelector {

    public static void main(String[] args) throws Exception {
        String[] students = {
                "서도경", "정준기", "경명수", "박현기","김관희"
        };
        /*
        String[] students = {
            "강동현", "경명수", "김가람", "김관희", "김기남", "김범수", "김복진",
            "김소영", "문선민", "박서경", "박수현", "박현기",
            "서도경", "성현동", "오현주", "이동현", "이상경", "이왕로", "이정호",
            "임현식", "장하은", "정준기", "차진호", "최보람", "한돈희", "홍정호",
            "황재천"
        };
        */
        int selectedNo = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            Thread.currentThread().sleep(100);
            selectedNo = (int)(Math.random() * 27);
        }
        System.out.println();
        
        System.out.printf("%s님이 당첨되셨습니다. 축하합니다!\n", students[selectedNo]);

    }

}



