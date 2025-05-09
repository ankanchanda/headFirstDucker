package ch4.somecode.pizza;

public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Cheese Pizza is getting prepared");
    }

    @Override
    public void bake() {
        System.out.println("Cheese Pizza is getting baked");
    }

    @Override
    public void cut() {
        System.out.println("Cheese Pizza is getting cut");
    }

    @Override
    public void box() {
        System.out.println("Cheese Pizza is getting packed");
    }
}
