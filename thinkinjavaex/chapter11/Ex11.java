// thinkinjava/chapter11/Ex11.java

import java.util.*;
import static com.wyett.util.Print.*;

public class Ex11 {
    public static void printAny(Collection c){
        Iterator s = c.iterator();
        while(s.hasNext())
            print(s.next() + " ");
        print();
    }
    public static void main(String[] args){
        ArrayList<Integer> al = 
            new ArrayList<Integer>(Arrays.asList(1,2,3));
        LinkedList<Character> ll = 
            new LinkedList<Character>(Arrays.asList('a','b','c'));
        HashSet<Float> hs = 
            new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
        TreeSet<Double> ts = 
            new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
        LinkedHashSet<Integer> lhs = 
            new LinkedHashSet<Integer>(Arrays.asList(1,2,3));
        printAny(al);
        printAny(ll);
        printAny(hs);
        printAny(ts);
        printAny(lhs);
    }
}