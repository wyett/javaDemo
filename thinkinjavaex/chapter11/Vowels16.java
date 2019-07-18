// thinkinjava/chapter11/Vowels16.java
import java.util.*;
import com.wyett.util.*;

public class Vowels16 {
    static void vowelCounter(Set<String> st){
        Set<Character> sc = new HashSet<Character>();
        Collections.addAll(sc,('A','E','I','O','U','a','e','i','o','u'));
        int allVowels = 0;
        for(String s: st){
            int counter=0;
            for(Collection v: s.toCharArray()){
                if(sc.contains(v)){
                    counter++;
                    allVowels++;
                }
            }
            System.out.print(s + ": "+ counter +", ");
        }
        System.out.println("allVowels: " + allVowels)
    }
    public static void main(String[] args){
        Set<String> ss = new TreeSet<String>(
          new TextFile("SetOperations.java", "\\W+");
        System.out.println(words);
        vowelCounter(ss);
    }
    
    
}