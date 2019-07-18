// thinkinjavaex/chapter11/Ex14.java
import java.util.*;
import static com.wyett.util.Print.*;

public class Ex14 {
    static void addMiddle(LinkedList<Integer> ll, Integer[] ia){
        ListIterator<Integer> ls = null;
        for(Integer x: ia){
            ls = ll.listIterator(ll.size()/2);
            ls.add(x);
        }
    }
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<Integer>();
        Integer[] is = {1,2,3,4,5,6,7,8,9,10};
        addMiddle(ll, is);
        print(ll);
    }
}