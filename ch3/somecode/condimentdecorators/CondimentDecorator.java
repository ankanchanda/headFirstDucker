package ch3.someCode.condimentDecorators;

import ch3.someCode.Beverage;

public abstract class CondimentDecorator extends Beverage{
    Beverage beverage;

    public abstract String getDescription();
}
