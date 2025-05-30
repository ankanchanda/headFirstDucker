package ch3.someCode;

import ch3.someCode.condimentDecorators.Mocha;
import ch3.someCode.condimentDecorators.Soy;
import ch3.someCode.condimentDecorators.Whip;

public class StarbuzzCafe {
    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        printDetails(beverage);

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        printDetails(beverage2);

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        printDetails(beverage3);
    }

    private static void printDetails(Beverage beverage) {
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
