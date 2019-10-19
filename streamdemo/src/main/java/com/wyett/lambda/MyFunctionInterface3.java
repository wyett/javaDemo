package com.wyett.lambda;

/**
 * @author : chelei
 * @description: TODO
 * @date : 2019/10/19 22:41
 */

public interface MyFunctionInterface3 {
    void hello();
    default void hello1() {}
    default void hello2() {}
}
