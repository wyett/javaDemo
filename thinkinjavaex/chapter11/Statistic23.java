// thinkinjava/chapter11/Statistic23.java

import java.util.*;
import static com.wyett.util.Print.*;

public class Statistic23{
    public static int getBestInt20(int n){
        Random rand = new Random(47);
        Map<Integer, Integer> mt = new TreeMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            int r = rand.nextInt(20);
            Integer frg = mt.get(r);
            mt.put(r, frg == null? 1 : frg+1);
        }
        // print(mt);
        // print(mt.entrySet());
        int max = 0;
        for(int j=0; j<mt.keySet().size(); j++){
            max = max<mt.get(j) ? mt.get(j):max;
        }
        Set<Map.Entry<Integer, Integer>> sm = 
            new LinkedHashSet<Map.Entry<Integer, Integer>>(mt.entrySet());
        int maxKey = 0;
        Iterator<Map.Entry<Integer, Integer>> im = sm.iterator();
        while(im.hasNext()){
            Map.Entry<Integer, Integer> findMax = im.next();
            if(findMax.getValue() == max){
                maxKey = findMax.getKey();
            }
        }
        return maxKey;
    }
    public static void main(String[] args){
        Map<Integer, Integer> m20 = new TreeMap<Integer, Integer>();
        for(int i=0; i<1000; i++){
            int x = getBestInt20(10000);
            Integer freg = m20.get(x);
            m20.put(x, freg == null? 1:freg+1);
        }
        print(m20);
    }
}