// thinkinjavaex/chapter15/Ex28.java

import java.util.*;


class A{}
class B extends A{}
class C extends A{}
class D extends B{}

public class Ex28 {
    class Generic1<T>{
        T t;
        void getT(T t) { this.t = t;}
    }
    
    class Generic2<T>{
        T t;
        T returnT(){
            return t;
        }
    }
    
    <T> void takeGeneric1(Generic1<? super T> gn1, T t1){
        gn1.getT(t1);
    }
    
    <T> T takeGeneric2(Generic2<? extends T> gn2){
        return gn2.returnT();
    }
    
    public static void main(String[] args){
        Ex28 ex = new Ex28();
        ex.takeGeneric1(ex.new Generic1<A>(), new B());
        ex.takeGeneric2(ex.new Generic2<A>());
    }
}