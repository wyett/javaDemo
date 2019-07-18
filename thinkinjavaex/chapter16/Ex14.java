// thinkinjavaex/chapter16/Ex14.java

import java.util.*;
import com.wyett.util.*;

public class Ex14 {
    public static void showLong(int len){
        CountingGenerator.Long cgl = 
            new CountingGenerator.Long();
        long[] l = new long[len];
        for(int i = 0; i < len; i++)
            l[i] = cgl.next();
        System.out.println(Arrays.toString(l));
    }
    public static void main(String[] args) {
        showLong(10);
    }
}