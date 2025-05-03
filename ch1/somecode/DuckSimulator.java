package ch1.somecode;

import ch1.somecode.behavior.fly.FlyNoWay;
import ch1.somecode.behavior.fly.FlyWithWings;
import ch1.somecode.behavior.quack.MuteQuack;
import ch1.somecode.behavior.quack.Quack;
import ch1.somecode.behavior.quack.Squeak;

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
