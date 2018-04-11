// 데이터 읽기 - int 값 읽기 II
package step22.ex3;

import java.io.FileReader;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test3.data");
        
        // Exam02_1을 실행하여 출력한 데이터를 read()로 읽는다. 
        // => 파일에서 4바이트를 읽어 4바이트 변수 int에 저장하라!
        // => 읽은 바이트를 비트이동 연산자를 값을 이동 시킨 후 변수에 저장해야 한다.
        int value = in.read();
        
        in.close();
        
        System.out.printf("%x\n", value);
    }
}






