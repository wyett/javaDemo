// thinkinjavaex/chapter16/Ex9.java
import java.util.*;

class Banana {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Banana " + id; }
}

class Peel<T> {
    private T t;
    private static long counter;
    private final long id = counter++;
    public Peel(T t) { this.t = t; }
    public String toString() {
        return "Peel " + id + t.toString();
    }
}

public class Ex9 {
    public static void main(String[] args){
        // 创建泛型数组
        // Peel<Banana>[] pb = new Peel<Banana>[10];
        List<Peel<Banana>> lpb = new ArrayList<Peel<Banana>>();
        for(int i = 0; i < 10; i++)
            lpb.add(new Peel<Banana>(new Banana()));
        System.out.println(lpb);
        System.out.println("lpb.get(0).getClass(): " + lpb.get(0).getClass());
    }
}