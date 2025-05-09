package ch4.somecode.pizza;

public class VeggiePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Veggie Pizza is getting prepared");
    }

    @Override
    public void bake() {
        System.out.println("Veggie Pizza is getting baked");
    }

    @Override
    public void cut() {
        System.out.println("Veggie Pizza is getting cut");
    }

    @Override
    public void box() {
        System.out.println("Veggie Pizza is getting packed");
    }
}
