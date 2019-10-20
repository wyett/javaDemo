package com.wyett.thinkinjava.concurrency;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 14:59
 * @description：TODO
 * @modified By：
 * @version: $
 */
class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call(){
        return "return of TaskWithResult" + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for(Future<String> fs : results)
            try{
                System.out.println(fs.get());
            } catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }
}
