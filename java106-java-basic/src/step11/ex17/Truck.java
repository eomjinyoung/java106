package step11.ex17;

public class Truck extends Car {
    @Override
    public void run() {
        System.out.println("덜컹 덜컹 달린다.");
    }
    
    public void dump() {
        System.out.println("짐을 내린다.");
    }
}
