package ch1;

import ch1.behavior.fly.FlyBehavior;
import ch1.behavior.quack.QuackBehavior;

public class RubberDuck extends Duck{

    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("I am not a real duck");
    }
}
