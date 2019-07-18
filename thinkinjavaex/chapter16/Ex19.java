// thinkinjavaex/chapter16/Ex19.java

import java.util.*;

class A{
    private int value = 0;
    A(int n) { this.value = n; }
    public boolean equals(Object o){
        return (o.getClass().getSimpleName() == "A" 
            && value == ((A)o).value ? true : false);
    }
    public String toString() {
        return "A " + value;
    }
    
}
public class Ex19 {
    public static void main(String[] args){
        A[] a1 = {new A(1), new A(2), new A(3)};
        A[] a2 = {new A(1), new A(2), new A(3)};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(a1.equals(a2));
    }
}