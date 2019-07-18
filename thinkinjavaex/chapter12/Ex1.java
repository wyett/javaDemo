// thinkinjavaex/chapter12/Ex1.java

class MyException extends Exception {
    public MyException(String msg){ super(msg); }
}

public class Ex1 {
    public static void f() throws MyException {
        System.out.println("Throwing Exception from f()");
        throw new MyException("print exception");
    }
    public static void main(String[] args){
        try {
            f();
        } catch (MyException e){
            e.printStackTrace(System.out);
        } finally {
            System.out.print("finally info");
        }
    }
}