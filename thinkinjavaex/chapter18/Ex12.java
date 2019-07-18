// thinkinjavaex/chapter18/Ex12.java

import java.io.*;
import java.util.*;

public class Ex12 {
    public static List<String>
    read(String filename) throws IOException {
        List<String> ls = new ArrayList<String>();
        BufferedReader in =
            new BufferedReader(new FileReader(filename));
        String s;
        while((s = in.readLine()) != null)
            ls.add(s);
        return ls;
    }
    public static void main(String[] args)
    throws IOException {
        if(args.length != 2) {
            System.err.println(
                "Usage: java Ex12 infile outfile");
            return;
        }
        List<String> ls = read(args[0]);
        PrintWriter out =
            new PrintWriter(
                new BufferedWriter(
                    new FileWriter(args[1])));
        int line = ls.size();
        for(ListIterator<String> it = 
            ls.listIterator(ls.size()); it.hasPrevious();)
            out.println(line-- + ": " + it.previous());
        out.close();
    }
}