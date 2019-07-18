// thinkinjava/chapter10/Ex25.java

import java.util.*;
import com.wyett.util.*;

public class Ex25 {
    public static void main(String[] args){
        Map<String, ArrayList<Integer>> ml = 
            new LinkedHashMap<String, ArrayList<Integer>>();
        List<Integer> words = new LinkedList<Integer>();
        words.addAll("SetOperations.java", "\\W+");
        Iterator itWords = words.iterator();
        int count = 0;
        while(itWords.hasNext()){
            String s = (String)itWords.next();
            count++;
            if(!ml.keySet().contains(s)){
                ArrayList<Integer> ai = 
                    new ArrayList<Integer>();
                ai.add(0, count);
                ml.put(s, ai);
            }else {
                ml.get(s).add(count);
                ml.put(s, ml.get(s));
            }
        }
        System.out.println(ml);
    }
}