// thinkinjavaex/chapter12/Ex4.java

class MyException extends RuntimeException{
    private String s = null;
    public MyException(String s){
        super(s);
        this.s = s;
    }
    public void printS(){
        System.out.println(s);
    }
}

public class Ex28{
    public static void f() throws MyException{
        throw new MyException("MyException from f()");
    }
    public static void main(String[] args){
        f();
    }
}