// thinkinjavaex/chapter11/Ex21.java

import java.util.*;
import static com.wyett.util.Print.*;

public class Ex21{
    public static void main(String[] args){
        List<String> si = new LinkedList<String>();
        si.addAll(new TextFile("SetOperations.java", "\\W+"));
        Collection.sort(si, String.CASE_INSENSITIVE_ORDER);
        print(si);
        Map<String, Integer> msi = new LinkedHashMap<String, Integer>();
        Iterator<String> it = si.iterator();
        while(it.hasNext()){
            String s = (String)it.next();
            if(si.contains(s)){
                int counter = msi.get(s);
                msi.put(s, counter == null? 1: counter+1)
            }
        }
        print(msi);
    }
}