package ch3.someCode;

public class Expresso extends Beverage{

    public Expresso() {
        this.description = "Expresso";
    }

    @Override
    public double cost() {
        return 1.99d;
    }
    
}
