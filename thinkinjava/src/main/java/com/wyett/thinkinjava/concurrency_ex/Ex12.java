package com.wyett.thinkinjava.concurrency_ex;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : chelei
 * @date : Created in 2019/6/26 17:06
 * @description: TODO
 * @modified By:
 * @version: $
 */
class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size){
        array = new int[size];
        len = size;
        for(int i = 0; i < size; i++)
            array[i] = -1;
    }
    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }
    public synchronized  boolean contains(int val){
        for(int i = 0; i < len; i++)
            if(array[i] == val) return true;
        return false;
    }
}

class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber() {
        // not thread-safe
        return serialNumber++;
    }
}

public class Ex12 {
    private static final int SIZE = 10;
    private static CircularSet serials =
            new CircularSet(1000);
    private static ExecutorService exec =
            Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable {
        public void run() {
            while(true) {
                int serial =
                        SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)){
                    System.out.println("Duplicate: " +serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        for( int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if(args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates delected");
            System.exit(0);
        } else {
            System.out.println("Provide a sleep time in sec.");
            System.exit(1);
        }
    }
}
