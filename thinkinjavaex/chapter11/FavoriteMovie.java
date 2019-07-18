// thinkinjavaex/chapter11/FavoriteMove.java

import java.util.*;
import static com.wyett.util.Print.*;

class ClassBuilder {
    private int key;
    public String next() {
        switch(key) {
            default:
            case 0 : key++; return "Snow White";
            case 1 : key++; return "Bashful";
            case 2 : key++; return "Doc";
            case 3 : key++; return "Dopey";
            case 4 : key++; return "Grumpy";
            case 5 : key++; return "Happy";
            case 6 : key++; return "Sleepy";
            case 7 : key = 0; return "Sneezy";            
        }
    } 
    public void fillA(String[] a){
        for(int i=0;i < a.length; i++)
            a[i] = next();
    }
    public Collection fill(Collection<String> c, int n){
        for(int i = 0; i< n; i++)
            c.add(next());
        return c;
    }
    
}

public class FavoriteMovie {
    public static void main(String[] args){
            ClassBuilder c = new ClassBuilder();
            String[] a = new String[10];
            c.fillA(a);
            for(String s: a)
                System.out.print(s + ",");
            System.out.println();
            System.out.println(c.fill(new ArrayList<String>(), 10));
            System.out.println(c.fill(new LinkedList<String>(), 10));
            System.out.println(c.fill(new HashSet<String>(), 10));
            System.out.println(c.fill(new LinkedHashSet<String>(), 10));
            System.out.println(c.fill(new TreeSet<String>(), 10));
    }

    
}