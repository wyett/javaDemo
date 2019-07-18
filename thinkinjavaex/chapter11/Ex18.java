// thinkinjavaex/chapter11/Ex18.java

import java.util.*;
import static com.wyett.util.Print.*;

class Gerbil{
    private int gerbilNumber;
    public Gerbil(int i){
        this.gerbilNumber = i;
    }
    public void hop(){
        print("Gerbil " + gerbilNumber + " hops();");
    }
}

public class Ex18{
    public static void main(String[] args){
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("ddd", new Gerbil(1));
        gerbils.put("bbb", new Gerbil(2));
        gerbils.put("fff", new Gerbil(3));
        gerbils.put("aaa", new Gerbil(4));
        gerbils.put("ccc", new Gerbil(5));
        gerbils.put("eee", new Gerbil(6));
        print(gerbils);
        print("------------------");
        Set<String> ss = new TreeSet<String>();
        for(String s: gerbils.keySet()){
            ss.add(s);
            print(s + ", ");
        }
        print(ss);
        print("------------------");
        Map<String, Gerbil> gerbils2 = new LinkedHashMap<String, Gerbil>();
        for(String sc: ss){
            print(sc + ", ");
            gerbils2.put(sc, gerbils.get(sc));
        }
        print(gerbils2);
        print("------------------");
        Map<String, Gerbil> gerbils3 = new TreeMap<String, Gerbil>(gerbils);
        print(gerbils3);
        
    }
}