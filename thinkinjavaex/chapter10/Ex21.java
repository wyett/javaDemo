// thinkinjavaex/chapter10/Ex21Interface.java

import static com.wyett.util.Print.*;

interface Ex21Interface{
    void f();
    class Ex21Inner{
        static void g(Ex21Interface e){
            e.f();
        }
    }
}

public class Ex21 implements Ex21Interface{
    public void f(){ print("Ex21.f()"); }
    public static void main(String[] args){
        Ex21 ex = new Ex21();
        Ex21Interface.Ex21Inner.g(ex);
    }
}