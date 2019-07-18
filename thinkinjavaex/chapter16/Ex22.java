// thinkinjava/chapter16/Ex22.java

import java.util.*;
import com.wyett.util.*;

public class Ex22 {
    private Random rand = new Random();
    public static void main(String[] args){
        int[] ia = ConvertTo.primitive(Generated.array(new Integer[20],
            new RandomGenerator.Integer(10)));
        System.out.println(Arrays.toString(ia));
        for(int i = 0; i < ia.length; i++){
            int index = Arrays.binarySearch(ia, i);
            if(index < 0)
                System.out.println(i + " not found");
            else
                System.out.println("index: " + i);
        }
        System.out.println("sort");
        Arrays.sort(ia);
        System.out.println(Arrays.toString(ia));
        for(int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if(index < 0) System.out.println(i + " not found");
            else
            System.out.println("Index: " + index + ", " + i);
        }    
    }
}