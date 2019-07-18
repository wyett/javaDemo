// thinkinjava/chapter15/CheckedList.java

import thinkinjava.chapter14.pets.*;
import java.util.*;

public class CheckList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(lIST probablyDogs){
        probablyDogs.add(new Cat());
    }
    public static void main(String[] args){
        List<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1);
        List<Dog> dogs2 = Collections.checkedList(
            new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch(Exception e) {
            System.out.println(e);
        }
        List<Pet> pets = Collections.checkedList(
            new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}