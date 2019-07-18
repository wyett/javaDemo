// thinkinjavaex/chapter15/OceanFish.java

import java.util.*;
import com.wyett.util.*;

class Generators {
    public static <T>  Collection<T>
    fill(Collection<T> coll, Generator<T> gen, int n){
        for(int i=0;i<n;i++)
            coll.add(gen.next());
        return coll;
    }
}

class BigFish{
    private static long counter=1;
    private final long id = counter++;
    //私有空构造器，禁止类被直接初始化
    private BigFish() {}
    public String toString(){ return "BigFish " + id; }
    public static Generator<BigFish> generator(){
        return new Generator<BigFish>(){
            public BigFish next() { return new BigFish(); }
        };
    }
}

class SmallFish {
    private static long counter=1;
    private final long id = counter++;
    private SmallFish(){}
    public String toString(){ return "SmallFish " + id; }
    public static Generator<SmallFish> generator =
        new Generator<SmallFish>() {
            public SmallFish next() { return new SmallFish(); }
        };
}

public class OceanFish{
    public static void eat(BigFish bf, SmallFish sf){
        System.out.println(bf + " eat " + sf);
    }
    public static void main(String[] args){
        Random rand = new Random();
        Queue<BigFish> cbf = new LinkedList<BigFish>();
        Generators.fill(cbf, BigFish.generator(), 15);
        List<SmallFish> lsf = new ArrayList<SmallFish>();
        Generators.fill(lsf, SmallFish.generator, 4);
        for(BigFish b: cbf)
            eat(b, lsf.get(rand.nextInt(lsf.size())));
    }
}






