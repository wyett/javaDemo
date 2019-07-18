// thinkinjavaex/chapter18/Ex041.java
import java.io.*;
import com.wyett.util.*;

public class Ex041 {
    public static void main(String[] args) {
        Directory.TreeInfo ti;
        if(args.length == 0)
            ti = Directory.walk("../chapter16");
        else
            ti = Directory.walk("../chapter16", args[0]);
        long total = 0;
        for(File file : ti)
            total += file.length();
        System.out.println(
            ti.files.size() + " file(s), " + total + " bytes");
    }
}