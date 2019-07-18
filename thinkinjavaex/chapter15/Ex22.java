// thinkinjava/chapter15/Ex22.java
// create a function by typeinfo label and reflect.
// It will use newInstance() to create some class instance
// these class has a construction with argument;

// class X<T> {
    // private T t;
    // public X(T t){
        // t.create();
    // }
    // public T create(){
        // return new T();
    // }
// }

// class XAsFactory<T> {
    // T x;
    // public XAsFactory(Class<T> kind){
        // try{
            // x = kind.newInstance();
        // }catch(Exception e){
            // throw new RuntimeException(e);
        // }
    // }
// }

import java.util.*;
import java.lang.reflect.*;
import static com.wyett.util.Print.*;


class B {}

class A  extends B{
    private String str;
    private A(String str){
        this.str = str;
    }
    public String toString(){
        return "A " + str;
    }
}

public class Ex22<T> {
    Class<T> kind;
    public Ex22(Class<T> kind){
        this.kind = kind;
    }
    public Object createNew(String typename)
        throws IllegalAccessException,
            InstantiationException,
            ClassNotFoundException {
        return Class.forName(typename).newInstance();
    }
    public Object createNew(String typename, Object... args)
        throws IllegalAccessException,
            InstantiationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {
        switch(args.length){
            case 1:
                return Class.forName(typename).
                    getConstructor(args[0].getClass()).
                    newInstance(args[0]);
            case 2:
                return Class.forName(typename).
                    getConstructor(args[0].getClass(), args[1].getClass()).
                    newInstance(args[0], args[1]);
        }
        return null;
    }
    public static void main(String[] args){
        Ex22<A> xa = new Ex22<A>(A.class);
        try {
            A a = (A)xa.createNew("test");
            System.out.println(a);
        } catch(IllegalAccessException e) {
            print("IllegalAccessException in main");
        } catch(InstantiationException e) {
            print("InstantiationException in main");
        } catch(ClassNotFoundException e) {
            print("ClassNotFoundException in main");
        } 
        
        
        // catch(NoSuchMethodException e) {
            // print("NoSuchMethodException in main");
        // } catch(InvocationTargetException e) {
            // print("InvocationTargetException in main");
        // }
    }
}

















