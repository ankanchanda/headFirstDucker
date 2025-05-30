package ch1.someCode;

import ch1.someCode.behavior.fly.FlyNoWay;
import ch1.someCode.behavior.fly.FlyWithWings;
import ch1.someCode.behavior.quack.MuteQuack;
import ch1.someCode.behavior.quack.Quack;
import ch1.someCode.behavior.quack.Squeak;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck(new FlyWithWings(), new Quack());
        mallard.display();
        mallard.swim();
        mallard.performQuack();
        mallard.performFly();

        mallard.setQuackbehavior(new Squeak());
        mallard.performQuack();

        Duck rubberDuck = new RubberDuck(new FlyNoWay(), new MuteQuack());
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.performQuack();
        rubberDuck.performFly();
    }    
}
