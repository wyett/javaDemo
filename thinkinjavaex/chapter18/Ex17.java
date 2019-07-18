// thinkinjavaex/chapter18/Ex17.java
import java.io.*;
import java.util.*;
import java.util.regex.*;
import com.wyett.util.*;

public class Ex17 {
    public static Map<Character, Integer>
    caculateAlphabet(String fname){
        Map<Character, Integer> mci = new HashMap<Character, Integer>();
        List<String> s = new TextFile(fname, "\n");
        // Iterator it = s.iterator();
        for(String item: s){
            char[] cs = item.toCharArray();
            for(int i = 0; i < cs.length; i++){
                char c = cs[i];
                int count = 0;
                if(mci.containsKey(c)){
                    count = mci.get(c) + 1;
                    mci.put(c, count);
                }else{
                    mci.put(c, 1);
                }
            }
        }
        return mci;
    }
    public static void main(String[] args){
        Map<Character, Integer> mci = caculateAlphabet("Ex17.java");
        for(Map.Entry<Character, Integer> mcientry : mci.entrySet())
            System.out.println(
                "key = '" + mcientry.getKey() 
                    + "', value = " +mcientry.getValue());
            
    }
}