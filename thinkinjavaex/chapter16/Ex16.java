// thinkinjavaex/chapter16/Ex16.java
import java.util.*;
import com.wyett.util.*;

public class Ex16 {
    public static void main(String[] args) {
        Integer[] ig = Generated.array(new Integer[20],
            new RandomGenerator.Integer(10));
        System.out.println(Arrays.toString(ig));
        System.out.println("reversed sort:");
        Arrays.sort(ig, Collections.reverseOrder());
        System.out.println(Arrays.toString(ig));
    }
}