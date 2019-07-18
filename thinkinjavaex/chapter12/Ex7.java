// thinkinjava/chapter12/Ex7.java

import java.io.*;
import java.util.logging.*;

// class LogException7 extends Exception {
    // private static Logger logger = 
        // Logger.getLogger("LogException7");
    // public LogException7(){
        // StringWriter trace = new StringWriter();
        // printStackTrace(new PrintWriter(trace));
        // logger.severe(trace.toString());
    // }
// }

public class Ex7{
    private static Logger logger = 
        Logger.getLogger("LogException7");
    public static void logException7(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    private static Integer[] is = new Integer[2];
    private int x = 5;
    public static void main(String[] args){
        try{
            is[2] = 5;
        }catch(ArrayIndexOutOfBoundsException e){
            // System.err.println(e);
            // e.printStackTrace();
            logException7(e);
        }
    }
}