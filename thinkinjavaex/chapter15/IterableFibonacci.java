// thinkinjavaex/chapter15/IterableFibonacci.java
import com.wyett.util.*;
import java.util.*;

public class IterableFibonacci
implements Generator<Integer>, Iterable<Integer> {
    private int count = 0;
    private int m;
    public Integer next() {
        return fib(count++);
    }
    private int fib(int n){
        if(n<2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public IterableFibonacci() {}
    public IterableFibonacci(int m){ this.m = m; }
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            public boolean hasNext() { return m > 0; }
            public Integer next() {
                m--;
                return IterableFibonacci.this.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        IterableFibonacci ifi = new IterableFibonacci();
        for(int i=0; i<10; i++)
            System.out.print(ifi.next() + " ");
        System.out.println();
        Iterator it = new IterableFibonacci(10).iterator();
        while(it.hasNext())
            System.out.print(it.next() + " ");
    }
}