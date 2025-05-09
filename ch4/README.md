# The observer pattern

### Situation
Tying your code to a concrete class can make it more fragile and less flexible.

`Duck duck = new MallardDuck();`: We want to use abstact types to keep code flexible but we have to create an instance of a concrete class

When we have a whole set of related concrete classes, decision of which to instantiate is made at runtime, ending up like this:
```
Duck duck;

if(picnic) {
    duck = new MallardDuck();
}
else if(hunting) {
    duck = new DecoyDuck();
}
else if(inBathTub) {
    new RubberDuck();
}
```

Issues:
- ends up in several parts of the application
- maintenance
- updates more difficult
- error-prone

code that makes use of lots of concrete classes, code may have to be changed as new concrete classes are added, so code will not be “closed for modification”.

### Solution:
identify the aspects that vary and separate them from what stays the same.



[SomeCode:](https://github.com/ankanchanda/headFirstDucker/commit/056893478d0767ad39446e15cee9b704761120fc)
```
Pizza orderPizza(String type) {
    Pizza pizza;
    if (type.equals("cheese")) {
        pizza = new CheesePizza();
    } else if (type.equals("greek")) {
        pizza = new GreekPizza();
    } else if (type.equals("pepperoni")) {
        pizza = new PepperoniPizza();
    }

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
}
```

To modify the changes, add a new pizza type or delete a pizza which you stopped selling. So the varying part is the creating the instance of the pizza on runtime.
