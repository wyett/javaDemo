// thinkinjavaex/chapter15/Ex20.java

interface TwoFunc {
    void A();
    void B();
}

class RealizeTwoFunc implements TwoFunc{
    public void A(){ System.out.println("RealizeTwoFunc A()"); }
    public void B(){ System.out.println("RealizeTwoFunc B()"); }
    public void C(){
         System.out.println("RealizeTwoFunc C()");
    }
}

class SecondClass {
    public static <T extends TwoFunc> void f(T t){
        t.A();
        t.B();
    }
}

public class Ex20{
    public static void main(String[] args){
        // Class o = new OtherClass.getClass();
        RealizeTwoFunc ex = new RealizeTwoFunc();
        System.out.println("----------");
        SecondClass.f(ex);
    }
}
