package ch3.someCode;

public abstract class Beverage {
    
    String description = "Unknown Description";

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
