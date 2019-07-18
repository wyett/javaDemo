// thinkinjavaex/chapter14/Ex15.java

import thinkinjava.chapter14.factory.*;
import java.util.*;

class Pet{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Pet>> petFactory =
        new ArrayList<Factory<? extends Pet>>();
    static {
        // petFactory.add(new Dog.Factory());
        petFactory.add(new Mutt.Factory());
        petFactory.add(new Pug.Factory());
        // petFactory.add(new Cat.Factory());
        petFactory.add(new EgyptianMax.Factory());
        petFactory.add(new Manx.Factory());
        // petFactory.add(new Rodent.Factory());
        petFactory.add(new Rat.Factory());
        petFactory.add(new Mouse.Factory());
        petFactory.add(new Hamster.Factory());
    }
    private static Random rand = new Random();
    public static Pet createRandom(){
        int n = rand.nextInt(petFactory.size());
        return petFactory.get(n).create();
    }
}

class Dog extends Pet {}

class Mutt extends Dog {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<Mutt>{
        public Mutt create() {
            return new Mutt();
        }
    }
}

class Pug extends Dog {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<Pug>{
        public Pug create() {
            return new Pug();
        }
    }
}

class Cat extends Pet {}

class EgyptianMax extends Cat {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<EgyptianMax>{
        public EgyptianMax create() {
            return new EgyptianMax();
        }
    }
}

class Manx extends Cat {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<Manx>{
        public Manx create() {
            return new Manx();
        }
    }
}

class Rodent extends Pet {}

class Rat extends Rodent {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<Rat>{
        public Rat create() {
            return new Rat();
        }
    }
}

class Mouse extends Rodent {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<Mouse>{
        public Mouse create() {
            return new Mouse();
        }
    }
}

class Hamster extends Rodent {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<Hamster>{
        public Hamster create() {
            return new Hamster();
        }
    }
}

public class Ex15 {
    public static void main(String[] args){
        for(int i=0; i<10; i++)
            System.out.println(Pet.createRandom());
    }
}
