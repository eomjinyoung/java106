// 버퍼 사용 후 - 파일 복사 및 시간 측정
package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_3.pdf");

        byte[] buf = new byte[8196]; // 보통 8KB 정도 메모리를 준비한다.
        int count = 0;
        
        long startTime = System.currentTimeMillis(); // 밀리초
        
        while ((count = in.read(buf)) != -1) ; // 파일을 끝까지 읽는다.
        
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
        
        in.close();
    }

}
