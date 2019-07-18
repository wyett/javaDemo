// thinkinjavaex/chapter15/Ex61.java
import java.util.*;

public class Ex61 {
    @SuppressWarnings("unchecked")
    public static <T> T[][] createBinaryArray(int m, int n, T t){
        Object[][] arrays = new Object[m][n];
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                // T t1 = new T()
                arrays[i][j] = t;
        return (T[][])arrays;
    }
    public static void main(String[] args){
        System.out.println(
            Arrays.deepToString(
                createBinaryArray(3,2,new BerylliumSphere())));
    }
}