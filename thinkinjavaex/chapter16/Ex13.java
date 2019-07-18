// thinkinajavaex/chapter16/Ex13.java
import java.lang.String.*;
import com.wyett.util.*;

public class Ex13 {
    public static void main(String[] args){
        char[] c1 = new char[3];
        CountingGenerator.Character cgc = 
            new CountingGenerator.Character();
        for(int i = 0; i < c1.length; i++) 
            c1[i] = cgc.next();
        // String s1 = new String(c1);
        System.out.println(new String(c1));
    }
}