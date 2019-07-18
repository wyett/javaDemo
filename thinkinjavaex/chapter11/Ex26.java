// thinkinjava/chapter10/Ex26.java

import java.util.*;
import com.wyett.util.*;

public class Ex26 {
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
        //replay
        Map<Integer, String> replay = 
            new LinkedHashMap<Integer, String>();
        List<Map.Entry<String, ArrayList<Integer>>> it = 
            new ArrayList<Map.Entry<String, ArrayList<Integer>>>();
        Iterator<Map.Entry<String, ArrayList<Integer>>> m = 
            ml.entrySet().iterator();
        while(m.hasNext()){
            Map.Entry<String, ArrayList<Integer>> mx = m.next();
            for(int i = 0; i<mx.getValue().size(); i++){
                replay.put(mx.getValue().get(i),  mx.getKey());
            }
        }
        System.out.println(replay);
    }
}