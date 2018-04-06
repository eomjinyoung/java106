package step19.ex8;

public class Car {
    Engine engine;
    
    public Car() {
        this.engine = new Engine();
    }
    
    public void move() {
        this.engine.run();
    }
}
