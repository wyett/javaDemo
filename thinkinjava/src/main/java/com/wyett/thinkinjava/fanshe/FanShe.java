package com.wyett.thinkinjava.fanshe;

/**
 * @author chelei
 * @date 2019/5/29 16:10
 */
public class FanShe {
    public static void main(String[] args) {
        // new 产生一个Student对象，一个Class对象
        Student stu1 = new Student();
        // 获取Class对象
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());


        //2
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);

        //3
        try {
            Class stuClass3 = Class.forName("fanshe.Student");
            System.out.println(stuClass3 == stuClass2);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
