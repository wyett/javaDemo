package thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/8 21:01
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class BusyWait_Ex221 {
    public static volatile boolean flag ;
    public static void main(String[] args) throws Exception {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        synchronized (this) {
                            notifyAll();
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        synchronized (r1) { r1.wait(); }
                    } catch (InterruptedException e) {
                        return;
                    }
                    print("Cycled");
                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
