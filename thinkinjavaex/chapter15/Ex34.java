// thinkinjavaex/chapter15/Ex34.java

abstract class SelfBounded34<T extends SelfBounded34<T>> {
    abstract T f(T arg);
    T g(T arg){
        System.out.println("SelfBounded34.g()");
        return f(arg);
    }
}

class D extends SelfBounded34<D> {
    D f(D arg){
        System.out.println("D.f()");
        return arg;
    }    
}

public class Ex34{
    public static void main(String[] args){
        D d = new D();
        d.f(d);
        System.out.println("-----------");
        d.f(d).g(d);
    }
}



