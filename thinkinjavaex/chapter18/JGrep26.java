// thinkinjavaex/chapter18/JGrep26.java
import java.nio.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.util.regex.*;
import static com.wyett.util.Print.*;
import com.wyett.util.*;
import java.io.*;

public class JGrep26 {
    public static void main(String[] args) throws Exception{
        if(args.length != 2){
            print("Usage: java JGrep26 file regex");
            System.exit(0);
        }
        print(System.getProperty("file.encoding"));
        // map
        FileChannel fc = 
            new FileInputStream(args[0]).getChannel();   
        ByteBuffer buffer = fc.map(
            FileChannel.MapMode.READ_ONLY, 0, fc.size());
        CharBuffer cb = Charset.forName(
            System.getProperty("file.encoding")).decode(buffer);
        String[] fileAsArray = cb.toString().split("\n");
        // pattern
        Pattern pattern = Pattern.compile(args[1]);
        Matcher m = pattern.matcher("");
        int index = 0;
        for(String line: fileAsArray){
            m.reset(line);
            while(m.find()){
                print(index++ + ": " + 
                    m.group() + "," +m.start());
            }
        }
    }
}
