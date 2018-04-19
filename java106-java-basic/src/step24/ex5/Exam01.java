// 동기화 처리 전 
package step24.ex5;

public class Exam01 {

    public static void main(String[] args) {
        Account account = new Account("111-11-1111-111", 100_0000);
        
        ATM 강남 = new ATM("강남", account);
        ATM 서초 = new ATM("서초", account);
        ATM 부산 = new ATM("부산", account);
        ATM 대전 = new ATM("대전", account);
        ATM 광주 = new ATM("광주", account);
        
        강남.start();
        서초.start();
        부산.start();
        대전.start();
        광주.start();
        

    }

}
