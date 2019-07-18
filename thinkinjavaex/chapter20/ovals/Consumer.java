package thinkinjava.concurrency_ex.ovals;

import java.util.concurrent.TimeUnit;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 16:28
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Consumer<T> implements Runnable{
    private int delay;
    private CommonQueue<T> myQueue;
    public Consumer(CommonQueue<T> myQueue, int delayTime){
        this.myQueue = myQueue;
        delay = delayTime;
    }
    public void run() {
        for(;;) {
            try {
//                myQueue.put(Class<? extends T>);
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
