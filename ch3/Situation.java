package ch3;

abstract class Beverage {
    private String description;

    Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract float cost();
}

class HouseBlend extends Beverage {

    HouseBlend(String description) {
        super(description);
    }

    @Override
    public float cost() {
        return 1f;
    }
}

class DarkRoast extends Beverage {

    DarkRoast(String description) {
        super(description);
    }

    @Override
    public float cost() {
        return 1f;
    }
}
// ...

public class Situation {
    
}
