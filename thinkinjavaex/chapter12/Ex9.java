// thinkinjavaex/chapter12/Ex9.java

import java.util.logging.*;
import java.io.*;

class MyException91 extends Exception {
    private String msg = null;
    public MyException91(String msg){
        super(msg);
        this.msg = msg;
    }
    public String getMessage(){
        return msg;
    }
}

class MyException92 extends Exception {
    private String msg = null;
    public MyException92(String msg){
        super(msg);
        this.msg = msg;
    }
    public String getMessage(){
        return msg;
    }
}

class MyException93 extends Exception {
    private String msg = null;
    public MyException93(String msg){
        super(msg);
        this.msg = msg;
    }
    public String getMessage(){
        return msg;
    }
}

class MyException9 extends Exception {
    public void f(int x) 
    throws MyException91, MyException92,MyException93 {
        if(x == 1){
            throw new MyException91("MyException91");
        } else if( x == 2){
            throw new MyException92("MyException92");
        } else if( x == 3){
            throw new MyException93("MyException93");
        }
    }
}

public class Ex9 {
    public static void main(String[] args){
        try{
            MyException9 ex = new MyException9();
            ex.f(1);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }

}







