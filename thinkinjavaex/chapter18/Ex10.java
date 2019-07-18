// thinkinjavaex/chapter18/Ex10.java
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Ex10{
    public static List<String>
    read(String filename) throws IOException {
        List<String> ls = new ArrayList<String>();
        BufferedReader in =
            new BufferedReader(new FileReader(filename));
        String s;
        while((s = in.readLine()) != null){
            ls.add(s);
            // System.out.println(s);
        }
        in.close();
        // System.out.println("================");
        // System.out.println(Arrays.asList(ls));
        return ls;
    }
    public static void main(String[] args) 
    throws IOException {
        if(args.length != 2)
            System.out.println("Usage: Ex10 filename word");
        else {
            List<String> ls = read(args[0]);
            ListIterator<String> lis = ls.listIterator(ls.size());
            // Pattern pattern = Pattern.compile(args[1]);
            String s;
            while(lis.hasPrevious()){
                s = lis.previous();
                // if(pattern.matcher(s).matches())
                if(s.indexOf(args[1]) != -1)
                    System.out.println(s);
            }
        }
    }  
}