// thinkinjavaex/chapter18/Ex07.java
import java.io.*;
import java.util.*;

public class Ex07 {
    public static List<String>
    read(String filename) throws IOException {
        List<String> ls = new ArrayList<String>();
        BufferedReader in =
            new BufferedReader(new FileReader(filename));
        String s;
        while((s = in.readLine()) != null){
            ls.add(s);
            System.out.println(s);
        }
        in.close();
        // System.out.println("================");
        // System.out.println(Arrays.asList(ls));
        return ls;
    }
    public static void main(String[] args) 
    throws IOException {
        // System.out.println(read("Ex07.java"));
        List<String> ls = read("Ex07.java");
        ListIterator<String> lis = ls.listIterator(ls.size());
        while(lis.hasPrevious())
            System.out.println(lis.previous());
    }  
}