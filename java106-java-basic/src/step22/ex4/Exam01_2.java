// 객체 읽기 - 파일이 데이터를 읽어 인스턴스로 만들기 
package step22.ex4;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test4.data");
        
        Member member = null;
        
        member = new Member();
        
        // 1) 이름 읽기
        // 2) 나이 읽기
        // 3) 성별 읽기
        
        in.close();
        
        System.out.printf("%s\n", member);
    }
}






