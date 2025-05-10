package ch4.somecode.pizza;

public class ClamPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Clam Pizza is getting prepared");
    }

    @Override
    public void bake() {
        System.out.println("Clam Pizza is getting baked");
    }

    @Override
    public void cut() {
        System.out.println("Clam Pizza is getting cut");
    }

    @Override
    public void box() {
        System.out.println("Clam Pizza is getting packed");
    }
}
