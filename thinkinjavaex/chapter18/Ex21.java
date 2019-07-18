// thinkinjavaex/chapter18/Ex21.java
import java.io.*;
import java.util.*;

public class Ex21{
    public static List<String> read()
    throws IOException{
        BufferedReader stdin = new BufferedReader(
            new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        String s;
        while((s = stdin.readLine()) != null && s.length() !=0 )
            list.add(s.toUpperCase());
        return list;
    }
    public static void write(List<String> list, String outFile) 
    throws IOException{
        PrintWriter stdout = 
            new PrintWriter(
                new BufferedWriter(
                    new FileWriter(outFile)));
        Iterator<String> lls = list.iterator();
        while(lls.hasNext())
            stdout.print(lls.next());
        stdout.close();
    }
    public static void main(String[] args) 
    throws IOException{
        if(args.length != 1){
            System.err.println(
                "Usage: java Ex21 dfile");
        }else{
            write(read(), args[0]);
        }
    }
}