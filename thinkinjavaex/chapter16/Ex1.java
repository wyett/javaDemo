// thinkinjavaex/chapter16/Ex1.java
import java.util.*;
import static com.wyett.util.Print.*;
// import thinkinjava.chapter16.*;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
}

class A { public String toString() { return "A con"; }}

public class Ex1 {
    public static void test(BerylliumSphere[] a){
        print(Arrays.asList(a));
    }
    public static <T> void test(T[] t){
        print(Arrays.asList(t));
    }
    public static void test(int[] a){
        print(Arrays.toString(a));
    }
    public static void main(String[] args){
        print("For objects, e.g., BerylliumSpheres:");
        test(new BerylliumSphere[3]);
        
        test(new BerylliumSphere[]{ new BerylliumSphere(),
        new BerylliumSphere(), new BerylliumSphere()});
        
        BerylliumSphere[] a = { new BerylliumSphere(),
            new BerylliumSphere(), new BerylliumSphere()};
        test(a);
        
        BerylliumSphere[] bs = new BerylliumSphere[2];
        test(bs);
        bs = a;
        test(bs);
        print("------------------------");
        test(new int[]{new Integer(0), new Integer(0)} );
        test(new int[2]);
        int[] c = {1,2};
        test(c);
    }
}

