package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;
import java.util.*;
import static com.wyett.util.Print.*;

/**
 * @author : chelei
 * @date : Created in 2019/7/2 16:37
 * @description: TODO
 * @modified By:
 * @version: $
 */
class Count {
    private int count = 0;
    private Random rand = new Random();
    // 通过yield和temp增加了失败的可能性
    public synchronized int increment() {
        int temp = count;
        // 在把count读取到temp，到递增temp，然后存入count，
        // nextBoolean有大约一半时间产生让步
        if(rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances =
            new ArrayList<Entrance>();
    // 通过某个特定入口进入的参观者的数量
    private int number = 0;
    private final int id;
    //因为是boolean+valatile 只会被读取和赋值，不需要同步对其访问
    private static volatile boolean canceled = false;
    public static void cancel() { canceled = true; }
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }
    // 递增number和count，然后sleep 100ms
    public void run() {
        while(!canceled) {
            synchronized (this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("stopping " + this);
    }
    public synchronized int getValue() { return number; }
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance: entrances)
            sum += entrance.getValue();
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        // ExecutorService.awaitTermination()等待每个任务结束
        // 尽管为false会退出，但entrance是有效的
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            print("Some task were not terminated!");
        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrances: " + Entrance.sumEntrances());
    }
}






