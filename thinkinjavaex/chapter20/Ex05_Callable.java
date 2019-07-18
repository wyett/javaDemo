package thinkinjava.concurrency_ex;
import java.util.*;
import java.util.concurrent.*;
import com.wyett.util.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 15:45
 * @description：TODO
 * @modified By：
 * @version: $
 */
class Ex05_Fibonacci implements Generator<Integer>, Callable{
    private int count = 0;
    private final int n;
    public Ex05_Fibonacci(int n){
        this.n = n;
    }
    public Integer next() { return fib(count++); }
    public int fib( int n){
        if(n < 2) return 1;
        return fib(n-1) + fib(n-2);
    }
    public Integer call(){
        int a = 0;
        for(int i=0; i< n; i++)
            a += next();
        return a;
    }
}
public class Ex05_Callable {
    public static void main(String[] args){
        ExecutorService exec =
                Executors.newCachedThreadPool();
        List<Future<Integer>> lfi =
                new ArrayList<Future<Integer>>();
//        Map<Future<Integer>, ArrayList<Integer>> mia =
//                new Map<Future<Integer>, ArrayList<Integer>>()
        for(int i=0; i< 20; i++)
            lfi.add(exec.submit(new Ex05_Fibonacci(i)));
        for(Future<Integer> fi : lfi){
            try{
                System.out.println(fi.get());
            }catch(InterruptedException e){
                System.out.println(e);
                return;
            }catch(ExecutionException e){
                System.out.println(e);
                return;
            }finally{
                exec.shutdown();
            }
        }
        System.out.println("====================");
//        System.out.println((lfi.toString()));
    }
}
