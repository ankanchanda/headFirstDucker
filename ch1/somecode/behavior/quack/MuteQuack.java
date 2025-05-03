package ch1.somecode.behavior.quack;

public class MuteQuack implements QuackBehavior{
    public void quack() {
        System.out.println("< silence >");
    }
}
