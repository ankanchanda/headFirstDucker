package ch3.somecode.condimentdecorators;

import ch3.somecode.Beverage;

public abstract class CondimentDecorator extends Beverage{
    Beverage beverage;

    public abstract String getDescription();
}
