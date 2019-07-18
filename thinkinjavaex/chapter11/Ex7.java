// thinkinjavaex/chapter11/Ex7.java

import java.util.*;
import static com.wyett.util.Print.*;

class Tester {
    public static int counter;
    private int id = counter++;
    public String toString(){
        return String.valueOf(id);
    }
}

public class Ex7 {
    public static void main(String[] args){
        Tester[] t = new Tester[10];
        for(int i=0; i<t.length; i++)
            t[i] = new Tester();
        print(Arrays.asList(t));
        List<Tester> lt = new ArrayList<Tester>();
        for(Tester x: t)
            lt.add(x);
        print("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2,6);
        print("sublist of Tester: " + sub);
        // make a copy
        List<Tester> copy = new ArrayList<Tester>(lt);
        copy.removeAll(sub);
        print("copy: " + copy);
        copy.removeAll(sub);
        lt = copy;
        print("remain lt: " + lt);
    }
}