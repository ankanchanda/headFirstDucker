package ch1.behavior.fly;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("can't fly");
    }
}
