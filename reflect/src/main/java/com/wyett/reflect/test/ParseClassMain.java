package com.wyett.reflect.test;

import com.wyett.reflect.example.ClassB;
import com.wyett.reflect.util.ParseClass;
import org.junit.Test;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/17 18:13
 * @description: TODO
 */

public class ParseClassMain {
    @Test
    public void test() {
        ClassB classB = new ClassB();
        ParseClass parseClass = new ParseClass(ClassB.class);
        parseClass.parse();
    }
}
