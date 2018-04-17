package bitcamp.java106.pms;

public class Test {
    
    public static void main(String[] args) {
        // 프로그램을 짜다 보면 특정 API를 사용할 때가 있다.
        // 그 API를 적용하기 전에 간단한 예제를 만들어 동작을 확인하라!
        String str = "/board/add?title=aaaa&content=bbb";
        String[] arr = str.split("\\?");
        for (String item : arr) {
            System.out.println(item);
        }

    }

}
