// thinkinjavaex/chapter18/Ex04.java
import java.io.*;
import java.util.*;
import com.wyett.util.*;
import static com.wyett.util.Print.*;
import java.util.regex.*;

public class Ex04 {
    public static void main(String[] args){
        long value = 0;
        long size;
        if(args.length == 0){
            for(File item: Directory.local(".", ".*")){
                print(item + ", " + item.length());
            }
        }else if(args.length == 1) {
            for(File item: Directory.walk(args[0], ".*")){
                print(item + ", " + item.length());
            }
                
        }else{
            for(File item: Directory.walk(args[0], args[1])){
                size = item.length();
                print(item + ", " + size);
                value += size;
            }
            System.out.println("total size is " + value);
        }
    }
}