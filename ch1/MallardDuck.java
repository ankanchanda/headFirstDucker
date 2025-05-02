package ch1;

import ch1.behavior.fly.FlyBehavior;
import ch1.behavior.quack.QuackBehavior;

public class MallardDuck extends Duck {

    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("I am a Mallard Duck");
    }
    
}
