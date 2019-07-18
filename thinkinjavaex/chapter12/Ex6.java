// thinkinjavaex/chapter11/Ex6.java

import java.util.logging.*;
import java.io.*;

class LogException1 extends Exception {
    private static Logger logger = 
        Logger.getLogger("LogException1");
    public LogException1(){
        StringWriter trace = new StringWriter();
        // printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
class LogException2 extends Exception {
    private static Logger logger = 
        Logger.getLogger("LogException2");
    public LogException2(){
        StringWriter trace = new StringWriter();
        // printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class Ex6 {
    public static void f() throws LogException1, LogException2 {
        throw new LogException1();
    }
    public static void g() throws LogException2 {
        throw new LogException2();
    }
    public static void main(String[] args){
        try{
            f();
        }catch(Exception e){}
        try{
            g();
        }catch(LogException2 e){}
    }
}