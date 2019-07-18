// thinkinjavaex/chapter16/Ex24.java

import java.util.*;
import com.wyett.util.*;

class A implements Comparable<A>{
    private int value = 0;
    A(int n) { this.value = n; }
    public int compareTo(A b){
        return (this.value < b.value ? -1 : (this.value == b.value ? 0 : 1));
    }
    public boolean equals(Object o){
        return (o.getClass().getSimpleName() == "A" 
            && value == ((A)o).value ? true : false);
    }
    public String toString() {
        return "A " + value;
    }
}
public class Ex24{
    public static void main(String[] args){
        A[] a1 = {new A(1), new A(2), new A(3)};
        A[] a2 = {new A(1), new A(2), new A(3)};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(a1.equals(a2));
        System.out.println("------------------");
        A[] a3 = {new A(1), new A(2), new A(3), new A(4), new A(5)};
        System.out.println(Arrays.toString(a3));
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));
        int index  = Arrays.binarySearch(a3, new A(3));
        System.out.println(index);
    }
}