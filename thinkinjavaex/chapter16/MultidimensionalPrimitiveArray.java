// thinkinjava/chapter16/MultidimensionalPrimitiveArray.java
import java.util.*;

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args){
        int[][] a = {
            {1,2,3},
            {4,5,6},
        };
        System.out.println(Arrays.deepToString(a));
        // [[I@15db9742, [I@6d06d69c]
        // System.out.println(Arrays.toString(a));
    }
}