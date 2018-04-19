package step24.ex5;

public class Account {
    String accountId;
    long balance;
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    public long withdraw(long money) {
        long b = this.balance;
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공
        b -= money;
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공
        if (b < 0)
            return 0;
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공
        this.balance = b;
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공
        return money;
    }
}






