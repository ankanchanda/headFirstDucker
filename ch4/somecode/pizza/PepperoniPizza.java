package ch4.somecode.pizza;

public class PepperoniPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Pepperoni Pizza is getting prepared");
    }

    @Override
    public void bake() {
        System.out.println("Pepperoni Pizza is getting baked");
    }

    @Override
    public void cut() {
        System.out.println("Pepperoni Pizza is getting cut");
    }

    @Override
    public void box() {
        System.out.println("Pepperoni Pizza is getting packed");
    }
}
