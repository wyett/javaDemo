package thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/6/27 17:18
 * @description: TODO
 * @modified By:
 * @version: $
 */

class SingleSynch {
    public synchronized void f() {
        for(int i = 0; i < 5; i++) {
            print("f()");
            Thread.yield();
        }
    }
    public synchronized void g() {
        for(int i = 0; i < 5; i++) {
            print("g()");
            Thread.yield();
        }
    }
    public synchronized void h() {
         for(int i = 0; i < 5; i++) {
            print("h()");
            Thread.yield();
        }
    }
}

class TripleSynch {
    private Object syncObjectG = new Object();
    private Object syncObjectH = new Object();
    public synchronized void f() {
        for(int i = 0; i < 5; i++) {
            print("f(TripleSynch)");
            Thread.yield();
        }
    }
    public void g() {
        synchronized (syncObjectG) {
            for(int i = 0; i < 5; i++) {
                print("g(TripleSynch)");
                Thread.yield();
            }
        }
    }
    public void h() {
        synchronized (syncObjectH) {
            for(int i = 0; i < 5; i++) {
                print("h(TripleSynch)");
                Thread.yield();
            }
        }
    }
}

public class Ex15 {
    public static void main(String[] args) throws Exception {
        final SingleSynch singleSynch = new SingleSynch();
        final TripleSynch tripleSynch = new TripleSynch();
        print("Test SingleSynch...");
        Thread t1 = new Thread(){
            public void run(){
                singleSynch.f();
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                singleSynch.g();
            }
        };
        t2.start();
        singleSynch.h();
        print("Test SingleSynch.t1...");
        t1.join();
        print("Test SingleSynch.t2...");
        t2.join();
        print("Test TripleSynch...");
        new Thread() {
            public void run() {
                tripleSynch.f();
            }
        }.start();
        new Thread() {
            public void run() {
                tripleSynch.g();
            }
        }.start();
        tripleSynch.h();
    }
}
