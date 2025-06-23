# The factory pattern

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

SomeCode: [1602af3](https://github.com/ankanchanda/headFirstDucker/commit/1602af3eda47cacc7c4cedf46cec436bf1712bfe)


### Factory Method Pattern
The Factory Method Pattern encapsulates object creation by letting subclasses decide what objects to create.

- The creator classes: Defines an abstract factory method that subclasses implement to produce products
    - Contains code that depend on an abstract product which is produce by the subclass. The creator doesn't know which concrete product was produced.
```
// Creator class
Class PizzaStore {
    createPizza();
    orderPizza();
}
```

- Concrete Creators: Classes that produce products.
```
// Concrete creator
class NYPizzaStore extends PizzaStore {
    createPizza();
}

// Concrete creator
class ChicagoPizzaStore extends PizzaStore {
    createPizza();
}
```

- The product classes: Factories produce products
```
class Pizza {}
```

- Concrete Product Classes
```
class NYStyleCheesePizza extends Pizza {}

class NYStylePepperoniPizza extends Pizza {}

class ChicagoStyleCheesePizza extends Pizza {}

class ChicagoStylePepperoniPizza extends Pizza {}
```

The `NYPizzaStore` encapsulates all the knowledge about how to make NY-style pizza and the `ChicagoPizzaStore` encapsulates all the knowledge about how to make Chicago-style pizza.

Abstract Creator class gives you an interface with a method for creating objects, also known as the “factory method.”

```
interface Product {
}

class ConcreteProduct implements Product {
}

abstract class Creator {
    factoryMethod();
    anOperation();
}

ConcreteCreator extends Creator {
    // has ConcreteProduct
    factoryMethod();
}
```

Summary:
- All products must implement the same interface so that the classes that use the products can refer to the interface, not the concrete class.

- Creator is a class the contains the implementations for all of the methods to manipulate products, except for the factory method.

- The abstract factoryMethod() is what all creator subclasses must implement

- ConcreteCreator implements the factoryMethod() which is the method actually produces products.

- ConcreteCreator is responsible for creating one or more concrete products. It is the only class that has the knowledge of how to create these products.

SomeCode: [3be1ea9](https://github.com/ankanchanda/headFirstDucker/commit/3be1ea9b83bf5ddcd23b0d1e13d6df9bf8a004cb#diff-cb6d5076f5d222987153a2b36e6348205080f12dadcb2249306de5c696074c41)

#### Issues
- Due to direct instantiation of object, it's depending on the concrete classes.
    - The version of the PizzaStore depends on all those pizza objects, because it's creating them directly.
    - If the implementation of these classes changes, then it might have to modify in PizzaStore as well.
    - Every new kind of pizza that gets added creates another dependency for PizzaStore.
    - It creates all the pizza objects right in the PizzaStore class instead of delegating to a factory.

### Principle
Depend upon abstractions and not upon concrete classes.

It suggests that high-level components should not depend on our low-level
components; rather, they should both depend on abstractions.

A high-level component is a behavior defined in terms of other low-level components. For example PizzaStore is a high-level component because it's behavior is defined in terms of pizzas- it creates all pizza objects, and prepares, bakes, cuts, etc..

### Guidelines to follow the principle
This is a guideline to strive for, rather than a rule you should follow all the time.

- No variable should hold a reference to a concrete class.
    - Solution: Use a factory to get around that.
- No class should derive from a concrete class.
    - Derive from an abstraction like interface or abstract class
- No method should override an implemented method of any of its base classes.
    - Methods implemented in the base class are meant to be shared by all the subclasses.

#### Reworking the pizza factory
- Family of Ingredients
    - New York uses one set of ingredients and Chicago another.
    - figure out how to handle families of ingredients.
- Building the ingredient factories
    - build a factory which will be responsible for creating each ingredient in the ingredient family.

SomeCode: [68384ca](https://github.com/ankanchanda/headFirstDucker/commit/68384ca201d72244eec41aebae54e4b2dc59abed)

#### Reworking the pizzas
The Pizza code uses the factory it has been composed with to produce the ingredients used in the pizza. The ingredients produced depend on which factory we’re using. The Pizza class doesn’t care; it knows how to make pizzas.

Now, it’s decoupled from the differences in regional ingredients and can be easily reused when there are factories.

SomeCode: [cefe7f5](https://github.com/ankanchanda/headFirstDucker/commit/cefe7f58c4e276cb8b3ab71ef3aececb3e39b567)