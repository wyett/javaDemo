// thinkinjavaex/chapter15/Decoration38.java

import java.util.*;

class Coffee {
    private static long counter=0;
    private final long id = counter++;
    private String coffeeType;
    public void set(String val) { coffeeType = val; }
    public String get() { return coffeeType; }
    public String toString() {
         return getClass().getSimpleName() + " " + id;
    }
}

class DecoratorCoffee extends Coffee {
    protected Coffee coffee;
    public DecoratorCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
    public void set(String val) { coffee.set(val); }
    public String get() { return coffee.get(); }
}

class Milk extends DecoratorCoffee {
    private final String milkType = "milk";
    public Milk(Coffee coffee) { super(coffee); }
    public String getMilk(){ return milkType; }
}

class Foam extends DecoratorCoffee {
    private final String foam = "foam";
    public Foam(Coffee coffee){ super(coffee); }
    public String getFoam() { return foam;}
}

class Chocolate extends DecoratorCoffee {
    private final String chocolate = "chocolate";
    public Chocolate(Coffee coffee){
        super(coffee);
    }
    public String getChocolate(){
        return chocolate;
    }
}


class Caramel extends DecoratorCoffee {
    private final String caramel = "caramel";
    public Caramel(Coffee coffee) {
        super(coffee);
    }
    public String getCaramel() { return caramel; }
}

class WhippedCream extends DecoratorCoffee {
    private final String whippedCream = "whippedCream";
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }
    public String getWhippedCream() { return whippedCream; }
}

public class Decoration38{
    public static void main(String[] args){
        Milk a = new Milk(new Coffee());
        Milk a1 = new Milk(
            new Foam(new Coffee()));
        Chocolate c = new Chocolate(new Caramel(new WhippedCream(
            new Foam(new Milk(new Coffee())))));
    }
}




