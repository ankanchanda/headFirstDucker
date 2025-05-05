# The decorator pattern

### Situation
Starbuzz that sells coffee has implemented an ordering solution. The abstract class is defined as follows

```
abstract class Beverage {
    string description;
    string getDescription() {
        return description
    }

    abstract float cost();
}
```

There are classes which extends Beverage and implements the cost method. Like, HouseBlend, DarkRoast, Decaf, Espresso, etc.

In addition to your coffee, you can also ask for several condiments like steamed milk, soy, and mocha, and have it all topped off with whipped milk. Starbuzz charges a bit for each condiment, so they really need to get them built into their order system.

They built classes that are combination of the base and top-offs. Each cost method computes the cost of the coffee along with the other condiments in the order. This will create a maintenance nightmare.

Issues to tackle:
- What happens if milk price goes up
- When there is a new topping