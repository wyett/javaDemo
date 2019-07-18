// thinkinjavaex/chapter18/Ex18.java
import java.io.*;
import java.util.*;

class TextFile2 extends ArrayList<String> {
    public static String read(String fname) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(
            new FileReader(new File(fname).getAbsoluteFile()));
        try{
            String s;
            while((s = in.readLine()) != null){
                sb.append(s);
                sb.append("\n");
            }
                
        }finally {
            in.close();
        }
        return sb.toString();
    }
    // write a single file in one method call;
    public static void write(String fname, String text)
    throws IOException{
        PrintWriter out = new PrintWriter(
            new File(fname).getAbsoluteFile());
        try{
            out.println(text);
        }finally{
            out.close();
        }
    }
    // read a file, split by any regular expression
    public TextFile2(String fname, String splitter)
    throws IOException {
        super(Arrays.asList(read(fname).split(splitter)));
        if(get(0).equals("")) remove(0);
    }
    public TextFile2(String fileName) throws IOException{
        this(fileName, "\n");
    }
    public void write(String fname) throws IOException{
        PrintWriter out = new PrintWriter(
            new File(fname).getAbsoluteFile());
        try{
            for(String item: this)
                out.println(item);
        } finally {
            out.close();
        }
    }
}
