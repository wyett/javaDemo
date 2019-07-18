// thinkinjavaex.chapter10.Ex13.java

/* func inner class
interface Ex13Interface {
    void f();
}

public class Ex13 {
    public Ex13Interface m(){
        class Ex13Base implements Ex13Interface {
            public void f(){
                System.out.println("Hi");
            }
        }
        return new Ex13Base();
    }
    public static void main(String[] args){
        Ex13 e = new Ex13();
        e.m().f();
    }
}
*/

// anonymous inner class
interface Ex13Interface {
    void f();
}

public class Ex13 {
    public Ex13Interface m() {
        return new Ex13Interface() {
            public void f() {
                System.out.println("Hi");
            }
        };
    }
    public static void main(String[] args){
        Ex13 e = new Ex13();
        e.m().f();
    }
}