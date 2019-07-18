// thinkinjavaex/chapter11/Ex8.java
import java.util.*;

class Gerbil{
    private int number;
    public Gerbil(int i){
        number = i;
    }
    public void hop(){
        System.out.println("gerbils No" + number + " hops");
    }
}

public class Ex8{
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for(int i=0; i<10; i++)
            gerbils.add(new Gerbil(i));
        Iterator<Gerbil>  ig = gerbils.iterator();
        while(ig.hasNext())
            ig.next().hop();
    }
}