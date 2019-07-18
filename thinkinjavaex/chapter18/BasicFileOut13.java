// thinkinjavaex/chapter18/BasicFileOut13.java
import java.io.*;

public class BasicFileOut13 {
    static String outfile = "BasicFileout13.out";
    public static void main(String[] args)
    throws IOException {
        // BufferedReader in = 
            // new BufferedReader(
                    // new FileReader("BasicFileOut13.java"));
        PrintWriter out = 
            new PrintWriter(
                new BufferedWriter(
                    new FileWriter(outfile)));
        // int lineCount = 1;
        LineNumberReader lnis = 
            new LineNumberReader(
                new FileReader("BasicFileOut13.java"));
        String s;
        while((s = lnis.readLine()) != null){
            // LineNumberInputStream lnis = 
                // new LineNumberInputStream();
            out.println(lnis.getLineNumber() + ": " + s);
        }
        out.close();
    }
}
