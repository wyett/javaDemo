// thinkinjavaex/chapter15/Ex12.java

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

public class Ex12 {
    public static void main(String[] args){
        // Ex11 ex = new Ex11();
        List<A> la = New.<A>list();
        Map<B, C> mbc = New.<B,C>map();
        Set<D> sd = New.<D>set();
        Queue<A> qa = New.<A>queue();
    }
}