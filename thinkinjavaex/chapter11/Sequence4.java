// thinkinjava/chapter11/Sequence4.java

import java.util.*;

public class Sequence4 {
    private ArrayList<Object> items = new ArrayList<Object>();
    public void add(Object x){
        items.add(x);
    }

    public Iterator iterator(){
        return items.iterator();
    }
    public static void main(String[] args){
        Sequence4 sequence4 = new Sequence4();
        for(int i=0; i<10; i++)
            sequence4.add(Integer.toString(i));
        Iterator is = sequence4.iterator();
        while(is.hasNext())
            System.out.print(is.next() + " ");
    }
    
}