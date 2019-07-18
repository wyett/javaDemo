package thinkinjava.concurrency_ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 14:34
 * @description: TODO
 * @modified By:
 * @version: $
 */
class FlowQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int maxSize;
    public FlowQueue(int maxSize) { this.maxSize = maxSize; }
    public synchronized void put(T v)
    throws InterruptedException{
        while(queue.size() >= maxSize)
            wait();
        queue.offer(v);
        maxSize++;
        notifyAll();
    }
    public synchronized T get() throws InterruptedException {
        while(queue.isEmpty())
            wait();
        T returnVal = queue.poll();
        maxSize--;
        notifyAll();
        return returnVal;
    }
}

class Item {
    private static int counter;
    private int id = counter++;
    public String toString() { return "Item " + id; }
}

class Producer implements Runnable {
    private int delay;
    private FlowQueue<Item> output;
    public Producer(FlowQueue<Item> output, int sleepTime) {
        this.output = output;
        delay = sleepTime;
    }
    public void run() {
        for(;;) {
            try {
                output.put(new Item());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch(InterruptedException e) { return; }
        }
    }
}

class Consumer implements Runnable {
    private int delay;
    private FlowQueue<?> input;
    public Consumer(FlowQueue<?> input, int sleepTime) {
        this.input = input;
        delay = sleepTime;
    }
    public void run() {
        for(;;) {
            try{
                System.out.println(input.get());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) { return; }
        }
    }
}

public class Ex24 {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.err.println("Usage java Ex24" +
                " <producer sleep time> <consumer sleep time>");
            System.exit(1);
        }
        int producerSleep = Integer.parseInt(args[0]);
        int consumerSleep = Integer.parseInt(args[1]);
        FlowQueue<Item> fq = new FlowQueue<Item>(100);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Producer(fq, producerSleep));
        exec.execute(new Consumer(fq, consumerSleep));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
