package com.wyett.thinkinjava.concurrency_ex;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/5 11:37
 * @description: TODO
 * @modified By:
 * @version: $
 */

class ADemo {
    private int id = 0;
    public ADemo(int id) {
        this.id = id;
    }
    public String toString() {
        return "count " + id;
    }
    public void test() {
        print(this + ", hello world");
    }
}
public class ThisDemo {
    public static void main(String[] args) {
        ADemo ad = new ADemo(1);
        ad.test();
    }
}
