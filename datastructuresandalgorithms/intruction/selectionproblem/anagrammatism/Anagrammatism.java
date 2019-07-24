package datastructuresandalgorithms.intruction.selectionproblem.anagrammatism;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/15 19:41
 * @description: Find words in two-dimensional array with alpha
 * @modified By:
 * @version: $
 */
//class TraverseMatrix {
//    private char[][] matrix;
//    public TraverseMatrix(char[][] matrix) {
//        this.matrix = matrix;
//    }
//    public String ArrToString(char[] arr) {
//        return String.valueOf(arr);
//    }
//    public List<String> getRowWords() {
//        List<String> ls = new ArrayList<String>();
//        for (int i = 0; i < matrix.length; i++)
//            ls.add(ArrToString(matrix[i]));
//        return ls;
//    }
//    public List<String> getColumnWords() {
//        List<String> ls = new ArrayList<String>();
//        for (int j = 0; j < matrix[i].length; j++)
//            for (int i = 0; i < matrix.length; i++)
//
//    }
//}
public class Anagrammatism {
    public static void main(String[] args) {
        char[][] arr = {{'t','h','i','s'}, {'t','h','a','t'}};
//        System.out.println(String.valueOf(arr));
        System.out.println(String.valueOf(arr[0]));
        for(int i=0; i < arr.length; i++)
            System.out.println("arr[" + i +"] : " + String.valueOf(arr[i]));
        for(int j = 0; j < arr[0].length; j++) {
            char[] tmp = new char[arr.length];
            for(int i = 0; i < arr.length; i++)
                tmp[i] = arr[i][j];
            System.out.println(String.valueOf(tmp));
        }
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i; j < arr.length; j++) {
//                tmp
//            }
//        }
    }
}
