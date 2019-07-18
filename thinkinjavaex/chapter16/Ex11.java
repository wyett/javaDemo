// thinkinjavaex/chapter16/Ex11.java
import static com.wyett.util.Print.*;
import java.util.*;

public class Ex11 {
    public static void main(String[] args){
        int[] ia = new int[2];
        ia[0] = new Integer(1);
        // autoboxing does not work here;
        ia[1] = new Integer(2);
        print("ia[]:" + Arrays.toString(ia));
        print(ia.getClass().getName());
        
        Integer[] Ia = new Integer[2];
        Ia[0] = (int)1;
        Ia[1] = (int)2;
        print("Ia[]: " + Arrays.toString(Ia));
        print(Ia.getClass().getName());
        print(Ia[0] instanceof Integer);
        for(int i = 0; i < Ia.length; i++)
            print(Ia[i].getClass().getName());
        Ia[0] = ia[0];
        print(Ia[0].getClass().getName());
        
        
    }
}