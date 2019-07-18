// thinkinjavaex/chapter11/Ex22.java

import java.util.*;
import com.wyett.util.Print.*;

class Word{
    private String word;
    private int wordcount;
    public Word(String w, int i){
        this.word = w;
        this.wordcount = i++;
    }
}

public class Ex22{
    public static void main(String[] args){
        List<String> ss = new LinkedList<String>();
        ss.addAll(new TextFile("SetOperations.java", "\\W+"));
        Collections.sort(ss, String.CASE_INSENSITIVE_ORDER);
        Set<Word> sw = new LinkedSet<Word>();
        print(ss);
        Iterator it = ss.iterator();
        while(it.hasNext()){
            String s = (String)it.next();
            int count = 0;
            for(int i=0; i<ss.size(); i++){
                if(s.equels(ss.get(i)))
                    count++;
            }
            Word w = new Word(s, count);
            sw.add(w);
        }
        print(sw);
    }
}