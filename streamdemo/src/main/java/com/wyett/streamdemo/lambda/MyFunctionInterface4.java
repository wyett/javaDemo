package com.wyett.lambda;

/**
 * @author : chelei
 * @description: TODO
 * @date : 2019/10/19 23:00
 */

public interface MyFunctionInterface4 {
    void hello();
    @Override
    String toString();
    @Override
    boolean equals(Object obj);
    default void hello1() {};
    default void hello2() {};
}
