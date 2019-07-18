// thinkinjavaex/chapter11/Vowels19.java
import java.util.*;
import com.wyett.util.Print.*;

public class Vowels19 {
	static void vowelCounter(Set<String> st) {
        Map<Character, Integer> vc = 
            new TreeMap<Character, Integer>();
        vc.put('A', 0);
        vc.put('E', 0);
        vc.put('I', 0);
        vc.put('O', 0);
        vc.put('U', 0);
        vc.put('a', 0);
        vc.put('e', 0);
        vc.put('i', 0);
        vc.put('o', 0);
        vc.put('u', 0);
        print("Original vc: " + vc);
        
		int allVowels = 0;
		for(String s : st) {
			for(Character v : s.toCharArray()) {		
				if(vc.keySet().contains(v)) {
                    int s = vc.get(v);
                    vc.put(v, ++s);
				}
			}
		}
		print();	
		print("Final vowels: " + vc);
	}
	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(
			new TextFile("SetOperations.java", "\\W+"));
		System.out.println(words);
		System.out.println();
		vowelCounter(words);		
	}		
}
