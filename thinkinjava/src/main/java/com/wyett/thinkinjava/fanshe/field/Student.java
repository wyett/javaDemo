package com.wyett.thinkinjava.fanshe.field;

/**
 * @author chelei
 * @date 2019/5/29 18:32
 */
public class Student {
    public Student() {

    }
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name " + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }
}
