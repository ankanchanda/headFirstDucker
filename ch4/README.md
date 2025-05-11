# The observer pattern

### Situation
Tying your code to a concrete class can make it more fragile and less flexible.

`Duck duck = new MallardDuck();`: We want to use abstract types to keep code flexible but we have to create an instance of a concrete class

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

SomeCode: [0568934](https://github.com/ankanchanda/headFirstDucker/commit/056893478d0767ad39446e15cee9b704761120fc)
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

So we separate out the pizza creation part using factory. Factories handle the details of object creation. Once we have a SimplePizzaFactory, our orderPizza() method becomes a client of that object. Now the orderPizza() method just cares that it gets a pizza that implements the Pizza interface so that it can call prepare(), bake(), cut(), and box().

Defining a simple factory as a static method should be fine, since it doesn’t need to instantiate an object to make use of the create method. 

NOTE: we can create it static but then we cannot extend or change the behavior of create method.

SomeCode: [cb901b8](https://github.com/ankanchanda/headFirstDucker/commit/cb901b8a9de13dd74603b4ecbbd752756ecc8421)

### New Issue
Now the franchise wants to expand its outlets to multiple regions. And the challenge here is to provide regionally different pizza. 

Each franchise might want to offer different styles of pizzas depending on where the franchise store is located and the tastes of the local pizza connoisseurs.

#### A Solution
If we take out SimplePizzaFactory and create three different factories—NYPizzaFactory, ChicagoPizzaFactory, and CaliforniaPizzaFactory, then we can just compose the PizzaStore with the appropriate factory and a franchise is good to go. That’s one approach.

Something like:
```
NYPizzaFactory nyFactory = new NYPizzaFactory();
PizzaStore nyStore = new PizzaStore(nyFactory);
nyStore.orderPizza("Veggie");

ChicagoPizzaFactory chicagoFactory = new ChicagoPizzaFactory();
PizzaStore chicagoStore = new PizzaStore(chicagoFactory);
chicagoStore.orderPizza("Veggie");
```

<h4>Issue</h4>
There is little control over the factories. In order to avoid this issue, we need a `FRAMEWORK` that ties the store and the pizza creation together.

#### Solution to above issue
We create the PizzaStore as an abstract class with abstract method create Pizza which individual extending class can return the pizza instance.

- PizzaStore
    - orderPizza()
    - abstract createPizza()

- NYStylePizzaStore: PizzaStore
    - createPizza()

- ChicagoStylePizzaStore: PizzaStore
    - createPizza()

PizzaStore:
```
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // This allows the subclass to decide the the pizza instance.
    protected abstract Pizza createPizza(String type);
}
```
A factory method handles object creation and encapsulates it in a subclass. This decouples the client code in the superclass from the object creation code in the subclass.

How do we order pizza?
```
PizzaStore nyPizzaStore = new NYPizzaStore();
nyPizzaStore.orderPizza("cheese");
```

The orderPizza then calls `createPizza("cheese")`
