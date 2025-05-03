package ch1.somecode;

import ch1.somecode.behavior.fly.FlyBehavior;
import ch1.somecode.behavior.quack.QuackBehavior;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void swim() {
        System.out.println("All ducks can swim, even decoys");
    }
    
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setQuackbehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
