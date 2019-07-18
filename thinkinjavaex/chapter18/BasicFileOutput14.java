// thinkinjava/chapter18/BasicFileOutput14.java
import java.io.*;
import java.util.*;

public class BasicFileOutput14 {
    static String outfile = "BasicFileOutput14.out";
    public static List<String> 
    read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(
            new FileReader(filename));
        List<String> list = new ArrayList<String>();
        String s;
        while((s = in.readLine()) != null)
            list.add(s);
        return list;
    }
    public static void main(String[] args)
    throws IOException {
        if(args.length != 1){
            System.err.println(
                "Usage: java BasicFileOutput14 filename");
            return;
        }
        List<String> ls = read(args[0]);
        PrintWriter out = 
            new PrintWriter(
                new BufferedWriter(
                    new FileWriter(outfile)));
        int lineCount = 1;
        long t1 = System.currentTimeMillis();
        for(String s: ls)
            out.println(lineCount++ + ": " + s);
        long t2 = System.currentTimeMillis();
        System.out.println("buffered: " + (t2 - t1));
        out.close();
        
        out = new PrintWriter(new FileWriter(outfile));
        lineCount = 1;
        long t3 = System.currentTimeMillis();
        for(String s: ls)
            out.println(lineCount++ + ": " + s);
        long t4 = System.currentTimeMillis();
        System.out.println("unbuffered: " + (t4 - t3));
        out.close();
        
    }
}