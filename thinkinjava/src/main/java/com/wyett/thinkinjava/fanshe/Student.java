package com.wyett.thinkinjava.fanshe;

/**
 * @author chelei
 * @date 2019/5/29 16:21
 */
public class Student {
    Student(Student str){
        System.out.println("default constructor = " + str);
    }
    public Student() {
        System.out.println("public no args constructor");
    }
    public Student(char name) {
        System.out.println("name: " + name);
    }
    public Student(String name, int age){
        System.out.println("name: " + name + " age: " + age);
    }
    protected Student(boolean n) {
        System.out.println("protected constructor n = " + n);
    }
    private Student(int age){
        System.out.println("private constructor age = " + age);
    }
}
