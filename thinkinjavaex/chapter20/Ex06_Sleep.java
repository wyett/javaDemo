package thinkinjava.concurrency_ex;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/5 10:02
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex06_Sleep implements Runnable{
    private static int count = 10;
    private static long counter = 0;
    private final long id = counter++;
    private int sec = 0;
    private Random rand = new Random();
    public Ex06_Sleep(int count) {
        this.count = count;
    }
    public void run(){
        try{
            while(count-- > 0) {
                sec = rand.nextInt(10);
                TimeUnit.MILLISECONDS.sleep(sec * 1000);
                System.out.println("task " + count +
                        " sleep " + sec + " second");
            }
        }catch(InterruptedException e){
            System.err.println("Interrupted");
        }
    }
}
