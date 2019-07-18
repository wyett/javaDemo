// thinkinjavaex/chapter14/Ex8.java

class A{}
class B extends A{}
class C extends B{}

public class Ex8 {
    public static void printClassInfo(Object o){
        if(o.getClass().getSuperclass() != null){
            System.out.println(o.getClass() + 
                " is a Inheritance of " + o.getClass().getSuperclass());
        }
        try{
            printClassInfo(o.getClass().getSuperclass().newInstance());
        } catch(InstantiationException e) {
            System.out.println("InstantiationException");
        } catch(IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
    }
    public static void main(String[] args){
        printClassInfo(new C());
    }
}