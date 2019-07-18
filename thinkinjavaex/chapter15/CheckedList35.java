// thinkinjavaex/chapter15/CheckedList.java

import thinkinjava.chapter15.coffee.*;
import java.util.*;

public class CheckList35 {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyMocha){
        probablyMocha.add(new Breve());
    }
    public static void main(String[] args){
        List<Mocha> mocha1 = new ArrayList<Mocha>();
        oldStyleMethod(mocha1);
        List<Mocha> mocha2 = Collections.checkedList(
            new ArrayList<Mocha>(), Mocha.class);
        try {
            oldStyleMethod(mocha2);
        } catch(Exception e) {
            System.out.println(e);
        }
        List<Coffee> coffees = Collections.checkedList(
            new ArrayList<Coffee>(), Coffee.class);
        coffees.add(new Mocha());
        coffees.add(new Breve());
    }
}