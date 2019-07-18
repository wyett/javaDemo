// thinkinjavaex/chapter14/Ex9.java

class A{
    int i;
}
class B extends A{
    String s;
}
class C extends B{
    int k;
    B b;
}

public class Ex9 {
    public static void printClassInfo(Object o){
        Object[] fields = o.getClass().getDeclaredFields();
        if(fields.length == 0){
            System.out.println(o.getClass() + " has no fields");
        }else if(fields.length > 0){
            for(Object f : fields){
                System.out.println(f);
            }
        }
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