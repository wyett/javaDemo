// thinkinjavaex/chapter15/Ex1

import thinkinjava.chapter14.pets.*;

public class Ex1<T> {
    private T a;
    public Ex1(T a) { this.a = a; }
    public void set(T a) { this.a = a; }
    public T get() { return a; }
    public static void main(String[] args){
        Ex1<Pet> e1 = new Ex1<Pet>(new Pet());
        Pet a = e1.get();
        System.out.println(e1.get());
        e1.set(new Dog());
        System.out.println(e1.get());
        e1.set(new Gerbil());
        System.out.println(e1.get());
    }
}