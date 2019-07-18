//thinkinjava/chapter16/Ex62.java
import java.util.*;

public class Ex62 {
    @SuppressWarnings("unchecked")
    public static <T> T[][] createBinaryArray(int m, int n, T t){
        // List<T>[][] arrays = (List<T>[][])new List[m][n];
        T[][] arrays = new T[m][n];
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                // arrays[i][j] = new ArrayList<T>(Arrays.asList(t));
                arrays[i][j] = t;
        return (T[][])arrays;
    }
    public static void main(String[] args){
        System.out.println(
            Arrays.deepToString(
                createBinaryArray(3,2,new BerylliumSphere())));
    }
}