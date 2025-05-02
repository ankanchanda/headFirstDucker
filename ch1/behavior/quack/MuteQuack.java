package ch1.behavior.quack;

public class MuteQuack implements QuackBehavior{
    public void quack() {
        System.out.println("< silence >");
    }
}
