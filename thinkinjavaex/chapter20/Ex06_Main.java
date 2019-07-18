package thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/5 10:02
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex06_Main {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++)
            exec.execute(new Ex06_Sleep(10));
        exec.shutdown();
    }
}
