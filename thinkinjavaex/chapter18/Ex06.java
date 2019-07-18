// thinkinjavaex/chapter18/Ex06.java
import java.io.*;
import java.text.*;
import java.util.*;
import com.wyett.util.*;

public class Ex06 {
    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateInstance(
            DateFormat.SHORT, Locale.US);
        if(args.length !=2 ){
            System.err.println(
                "Usage: java Ex06 path date"
            );
            return;
        }
        long tmp = 0;
        try {
            df.setLenient(false);
            tmp = df.parse(args[1]).getTime();
        } catch(ParseException pe){
            pe.printStackTrace();
            return;
        }
        final long modTime = tmp;
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                if(modTime < file.lastModified())
                    System.out.println(file);
            }
        }, "java").start(new String[] {args[0]});
            
    }
}