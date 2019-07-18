// thinkinjavaex/chapter10/U.java

import static com.wyett.util.Print.*;

interface U{
    void f();
    void g();
    void h();
}

class A{
    public U buildU(){
        return new U(){
            public void f(){ print("A.U.f()"); }
            public void g(){ print("A.U.g()"); }
            public void h(){ print("A.U.h()"); }
        };
    }
}

class B{
    // U[] list = new U[]();
    private U[] list;
    B(int i){
        list = new U[i];
    }
    void addU(U u, int i){
        list[i] = u;
    }
    void eraseU(int i){
        list[i] = null;
    }
    void showU(){
        for(U s :list){
            if(s != null)
                print(s);
            else
                print("I'm null");
        }
    }
}

public class Ex23{
    public static void main(String[] args){
        A a0 = new A();
        A a1 = new A();
        A a2 = new A();
        B b = new B(3);
        b.addU(a0.buildU(),0);
        b.addU(a1.buildU(),1);
        b.addU(a2.buildU(),2);
        b.showU();
    }
}
 