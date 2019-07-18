// thinkinjava/chapter12/Ex8.java

import java.util.logging.*;
import java.io.*;

// class NullException extends Exception {
    // public NullException
// }

public class Ex8 {
    private static Integer x = null;
    public static void nullException(Exception e){
        throw new NullPointerException();
    }
    public static void main(String[] args){
        try{
            System.out.println(x.toString());
        }catch(Exception e){
            e.printStackTrace();
            nullException(e);
        }
        try{
            x = 10;
            System.out.println(x.toString());
        }catch(Exception e){
            e.printStackTrace();
            nullException(e);
        }
    }
}