// 사용자 정의 데이터 타입 - 인스턴스 메서드
package step07;

public class Score3 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    // 다음 연산자는 계산을 수행할 때마다 인스턴스의 주소를 파라미터로 받아야 한다.
    public static void calculate(Score3 score) {
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f;
    }
}







