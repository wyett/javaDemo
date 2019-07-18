package thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/9 9:52
 * @description: TODO
 * @modified By:
 * @version: $
 */
class Ex211_ARunnable implements Runnable {
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch(InterruptedException e) {
                print("InterruptedException Ex211_ARnnable.run()");
            }
        }
        print("test");
    }
}
class Ex211_BRunnable implements Runnable {
    private Runnable r;
    public Ex211_BRunnable(Runnable r) {
        this.r = r;
    }
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e) {
            print("InterruptedException Ex211_BRnnable.run()");
        }
        synchronized (r) { r.notifyAll(); }
    }
}
public class Ex211 {
    public static void main(String[] args) throws Exception {
        Runnable r1 = new Ex211_ARunnable(),
                r2 = new Ex211_BRunnable(r1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(2);
        exec.shutdown();
    }
}






