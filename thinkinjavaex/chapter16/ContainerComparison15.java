// thinkinjavaex/chapter15/ContainerComparison15.java
import java.util.*;
import com.wyett.util.*;
import static com.wyett.util.Print.*;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
}

public class ContainerComparison15 {
    public static class
    BerylliumSphereGenerator implements Generator<BerylliumSphere> {
        public BerylliumSphere next(){
            return new BerylliumSphere();
        }
    }
    public static void main(String[] args){
        BerylliumSphere[] bs = new BerylliumSphere[5];
        BerylliumSphereGenerator cc = new BerylliumSphereGenerator();
        Generated.array(bs, cc);
        print(Arrays.toString(bs));
        print(bs[4]);
        List<BerylliumSphere> lbs = 
            new ArrayList<BerylliumSphere>();
        for(int i = 0; i < 5; i++)
            lbs.add(cc.next());
        print(lbs);
        print(lbs.get(4));
    }
}
