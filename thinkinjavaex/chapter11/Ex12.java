// thinkinjavaex/chapter11/Ex12.java
import java.util.*;
import static com.wyett.util.Print.*;

public class Ex12 {
    public static void main(String[] args){
        List<Integer> li1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        List<Integer> li2 = new ArrayList<Integer>(Arrays.asList(6,7,8,9,10));
        print(li1);
        print("li1 size: " + li1.size());
        print(li2);
        print("li2 size: " + li2.size());
        ListIterator<Integer> lii1 = li1.listIterator(li1.size());
        ListIterator<Integer> lii2 = li2.listIterator();

        while(lii2.hasNext()){
            lii2.next();
            lii2.set(lii1.previous());
        }
        print(li1);
        print(li2);
    }
}