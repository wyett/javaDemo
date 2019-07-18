// thinkinjavaex/chapter12/Ex25.java

class ExceptionA extends Exception{}
class ExceptionB extends ExceptionA{}
class ExceptionC extends ExceptionB{}

class A {
    void f() throws ExceptionA{
        throw new ExceptionA();
    }
}
class B extends A {
    void f() throws ExceptionB{
        throw new ExceptionB();
    }
}

class C extends B {
    void f() throws ExceptionC{
        throw new ExceptionC();
    }
}

public class Ex25{
    public static void main(String[] args){
        try{
            A ac = new C();
            ac.f();
        }catch(ExceptionC e){
            e.printStackTrace();
            System.out.println("Caught C");
        }catch(ExceptionB e){
            e.printStackTrace();
            System.out.println("Caught B");
        }catch(ExceptionA e){
            e.printStackTrace();
            System.out.println("Caught A");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Caught Exception");
        }
        
    }
}




