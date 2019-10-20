package com.wyett.lambda;

import java.util.function.Function;

/**
 * @author : chelei
 * @description: TODO
 * @date : 2019/10/19 22:04
 */
public class lambdademo1 {
    // Simple lambda
    public static void simpleLambda() {
        Function<String, Object> f = a -> {
            return a;
        };
    }

    public static String hello(String str1, String str2) {
        System.out.println(str1 + str2);
        return str1 + str2;
    }

    public static void main(String[] args) {
        // demo1
        // System.out.println(simpleLambda());

        // No argument
        // demo2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        new Thread(() -> {
            System.out.println("hello");
        }).start();

        // functionalInterface1, with annotation FunctionInterface
        MyFunctionInterface1 f = () -> {
            System.out.println("hello");
        };
        f.hello();


        // functionInterface2 only one func
        MyFunctionInterface2 f2 = () -> {
            System.out.println("hello");
        };
        f2.hello();

        // functionInterface3 has more func, other func has default modifiler
        MyFunctionInterface3 f3 = () -> {
            System.out.println("hello");
        };
        f3.hello();
//        f3.hello1();

        // functionInterface4 with func of Object interface
        MyFunctionInterface4 f4 = () -> {
            System.out.println("hello");
        };
        f4.hello();



        // With argument
        // one argument, no argument type
//        MyFunctionInterface5 f5 = s -> System.out.println(s);

        // one argument, code block
        MyFunctionInterface5 f5 = s -> {
            System.out.println(s);
            System.out.println("hello");
        };

        // two argument, with () ,no argument type
//        MyFunctionInterface6 f6 = (s, i)-> System.out.println(s + i);
        MyFunctionInterface6 f6 = (String s, int i)-> System.out.println(s + i);

        // With return
        MyFunctionInterface7 f7 = s -> null;
        f7.echo("MyFunctionInterface7.hello");

        // quote static func
        MyFunctionInterface8 f8 = lambdademo1::hello;
        f8.hello("MyFunctionInterface8", "hello");

        // quote static func2
        MyFunctionInterface9 f9 = LambdaHello::hello;
        f9.hello("MyFunctionInterface.f9");


    }




}














