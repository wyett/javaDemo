package com.wyett.thinkinjava.fanshe;
import java.lang.reflect.Constructor;
/**
 * @author chelei
 * @date 2019/5/29 16:35
 */
public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("fanshe.Student");

        // all public Constructor
        System.out.println("*******************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray) {
            System.out.println(c);
        }

        // all Constructor
        System.out.println("*******************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray) {
            System.out.println(c);
        }

        // public and no args
        System.out.println("*******************");
        Constructor con = clazz.getConstructor(null);
        System.out.println("con = " + con);
        Object obj = con.newInstance();
        System.out.println("obj = " + obj);
        Student stu = (Student)obj;

        // private
        System.out.println("*******************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        con.setAccessible(true);
        obj = con.newInstance('m');
    }
}
