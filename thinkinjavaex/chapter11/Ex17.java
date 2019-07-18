// thinkinjavaex/chapter11/Ex17.java

import java.util.*;
import com.wyett.util.Print.*;

class Gerbil {
	private int gerbilNumber;
	public Gerbil(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("Gerbil " + gerbilNumber + " hops");
	}
}

public class Ex17 {
	public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("Spot", new Gerbil(1));
        gerbils.put("Fuzzy", new Gerbil(2));
        // for(String g: gerbils.keySet()){
            // System.out.println(gerbils.get(g) + ": " +g);
            // gerbils.get(g).hop();
        // }
        Iterator<String> it = gerbils.keySet().iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.println(s + ": " + gerbils.get(s).hop());
        }
		// Iterator<String> it = gerbils.keySet().iterator();
		// while(it.hasNext()) {
			// String s = it.next();
			// System.out.print(s + ": ");
			// gerbils.get(s).hop();
	}
}