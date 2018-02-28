// 소스 파일과 바이트코드 파일을 분리하기 
public class Exam05 {
    public static void main(String[] args) {
        System.out.println("Exam05");
    }
}
class G {}

// 소스 코드와 컴파일로 만들어진 바이트코드 파일을 분리해 두면 
// 나중에 사용자에게 배포하는 파일을 만들 때 편하다.
// 그래서 보통 다음과 같은 폴더 이름을 분리한다.
// src - source 파일을 두는 폴더 
// bin - binary 파일(컴파일로 생성된 바이트코드 파일)을 두는 폴더
//
// 컴파일 방법
// > javac -d 컴파일결과를둘폴더경로 소스파일경로
// > javac -d ./bin ./src/Exam05.java
//
// 다른 폴더에 있는 바이트코드 실행하기
// 1) 그 폴더로 찾아가서 실행한다.(비추천)
// 2) JVM에게 바이트코드 파일이 있는 위치를 알려준다.
// > java -classpath 클래스파일이있는폴더위치 클래스명
// > java -cp 클래스파일이있는폴더위치 클래스명
// > java -classpath ./bin Exam05
// > java -cp ./bin Exam05
//    







