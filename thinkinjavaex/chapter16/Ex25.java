// thinkinjavaex/chapter16/Ex25.java
import java.util.*;
import static com.wyett.util.Print.*;

class MyList extends ArrayList{
    List myList = new ArrayList();
    MyList(List l) { this.myList = l; }
    @SuppressWarnings("unchecked")
    MyList getReverseList(){
        ListIterator mli = myList.listIterator(myList.size());
        List reverseList = new ArrayList();
        while(mli.hasPrevious()){
            reverseList.add(mli.previous());
        }
        return new MyList(reverseList);
    }
}

public class Ex25 {
    public static void main(String[] args) {
        List<Integer> aList =
            new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        print(aList);
        print(aList.get(4));
        aList.add(new Integer(6));
        aList.addAll(new ArrayList<Integer>(Arrays.asList(7,8)));
        print(aList);
        print(aList.subList(2,4));
        MyList ml = new MyList(aList);
        print((ml.getReverseList()).myList);
    }
}