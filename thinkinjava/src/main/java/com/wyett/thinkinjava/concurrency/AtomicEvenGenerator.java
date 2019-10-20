package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.atomic.*;
/**
 * @author : chelei
 * @date : Created in 2019/6/26 19:37
 * @description: TODO
 * @modified By:
 * @version: $
 */
public class AtomicEvenGenerator extends IntGenerator{
    private AtomicInteger currentEvenValue =
            new AtomicInteger(0);
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
