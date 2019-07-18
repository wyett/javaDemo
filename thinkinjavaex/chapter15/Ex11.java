// thinkinjavaex/chapter15/Ex11.java

import com.wyett.util.New;
import static com.wyett.util.Print.*;
import java.util.*;

class A {
    A(){ print("constructor A()"); }
}
class B extends A {
    B(){ print("constructor B()"); }
}
class C extends A {
    C(){ print("constructor C()"); }
}
class D extends A {
    D(){ print("constructor D()"); }
}

public class Ex11 {
    public static void main(String[] args){
        // Ex11 ex = new Ex11();
        List<A> la = New.list();
        Map<B, C> mbc = New.map();
        Set<D> sd = New.set();
        Queue<A> qa = New.queue();
    }
}