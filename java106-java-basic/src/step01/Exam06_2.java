// 부동소수점의 리터럴 - 크기
package step01;

public class Exam06_2 {
    public static void main(String[] args) {
        
        // 부동소수점도 크기에 따라 작성하는 방법이 다른다.
        System.out.println(3.14); // 8바이트 크기의 부동소수점
        
        // 부동소수점 뒤에 F나 f를 붙이면 4바이트 크기의 부동소수점으로 다룬다.
        // - 주로 소문자를 붙인다.
        System.out.println(3.14f); // 4바이트 크기의 부동소수점

        // 궁금?
        // - 정수는 메모리의 크기에 따라 최소값과 최대값이 정해진다.
        // - 부동소수점의 최소/최대값은?
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        
        // 4byte 부동소수점 테스트
        System.out.println(987.6543f);
        System.out.println(987654.3f);
        System.out.println(9.876543f);

        System.out.println(987654.345678f);
        System.out.println(98765434567.8f);
        System.out.println(9.87654345678f);
    }
}