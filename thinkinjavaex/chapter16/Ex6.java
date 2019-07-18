// thinkinjavaex/chapter16/Ex6.java

import java.util.*;

// public class Ex6<T>{
    // public static <T> T[][] 
    // createBinaryArray(int m, int n, T t){
        // T[][] arrays = new T[m][n];
        // for(int i = 0; i < m; i++)
            // for(int j = 0; i < n; j++)
                // arrays[i][j] = new T();
        // return arrays;    
    // }
    // public static void main(String[] args){
        // System.out.println(
            // Arrays.deepToString(
                // createBinaryArray(3,2,new BerylliumSphere())));
    // }
// }

// public class Ex6 {
    // @SuppressWarnings("unchecked")
    // public static <T> T[][] createBinaryArray(int m, int n, T t){
        // List<T>[][] arrays = (List<T>[][])new List[m][n];
        // for(int i = 0; i<m; i++)
            // for(int j = 0; j<n; j++)
                // arrays[i][j] = new ArrayList<T>();
        // return (T[][])arrays;
    // }
    // public static void main(String[] args){
        // System.out.println(
            // Arrays.deepToString(
                // createBinaryArray(3,2,new BerylliumSphere())));
    // }
// }

public class Ex6 {
    // @SuppressWarnings("unchecked")
    public static BerylliumSphere[][] createBinaryArray(int m, int n){
        BerylliumSphere[][] arrays = 
            new BerylliumSphere[m][n];
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                arrays[i][j] = new BerylliumSphere();
        return arrays;
    }
    public static void main(String[] args){
        System.out.println(
            Arrays.deepToString(
                createBinaryArray(3,2)));
    }
}