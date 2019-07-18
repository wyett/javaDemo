// thinkinjavaex/chapter12/Ex10.java

class ExceptionA extends Exception {
    public ExceptionA(String msg){ super(msg); }
}
class ExceptionB extends Exception {
    public ExceptionB(String msg){ super(msg); }
}
class Ex10Class {

}
public class Ex10{
    public static void g() throws ExceptionB {
        throw new ExceptionB("ExceptionB from Ex10Class");
    }
    public static void f() {
        try{
            g();
        }catch(ExceptionB e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args){
        f();
    }
}
/*
ExceptionB: ExceptionB from Ex10Class
	at Ex10.g(Ex10.java:14)
	at Ex10.f(Ex10.java:18)
	at Ex10.main(Ex10.java:26)
Exception in thread "main" java.lang.RuntimeException: ExceptionB: ExceptionB from Ex10Class
	at Ex10.f(Ex10.java:21)
	at Ex10.main(Ex10.java:26)
Caused by: ExceptionB: ExceptionB from Ex10Class
	at Ex10.g(Ex10.java:14)
	at Ex10.f(Ex10.java:18)
	... 1 more
*/
/*
ExceptionB: ExceptionB from Ex10Class
	at Ex10.g(Ex10.java:14)
	at Ex10.f(Ex10.java:18)
	at Ex10.main(Ex10.java:26)
Exception in thread "main" java.lang.RuntimeException: ExceptionB: ExceptionB from Ex10Class
	at Ex10.f(Ex10.java:21)
	at Ex10.main(Ex10.java:26)
Caused by: ExceptionB: ExceptionB from Ex10Class
	at Ex10.g(Ex10.java:14)
	at Ex10.f(Ex10.java:18)
	... 1 more
*/
