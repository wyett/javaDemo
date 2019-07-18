package thinkinjava.concurrency_ex;
import java.util.*;
import com.wyett.util.Generator;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/3 15:58
 * @description：TODO
 * @modified By：
 * @version: $
 */


public class Ex02_Fibonacci implements Generator<Integer>, Runnable {
    private int count = 0;
    private final int n;
    public Ex02_Fibonacci(int n) { this.n = n; }
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public void run() {
        Integer[] sequence = new Integer[n];
        for(int i = 0; i < n; i++)
            sequence[i] = next();
        System.out.println(
                "Seq. of " + n + ": " + Arrays.toString(sequence));
    }
}
