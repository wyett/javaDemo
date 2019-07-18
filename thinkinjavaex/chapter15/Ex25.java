// thinkinjavaex/chapter15/Ex25.java

interface A {}
interface B {}

class C implements A, B {
    public String toString() {
        return "C";
    }
}

public class Ex25 {
    <T extends A> void a(T t) { System.out.println("A(" + t + ")");}
    <T extends B> void b(T t) { System.out.println("B(" + t + ")");}
    public static void main(String[] args){
        C c = new C();
        Ex25 e = new Ex25();
        e.a(c);
        e.b(c);
    }
}

