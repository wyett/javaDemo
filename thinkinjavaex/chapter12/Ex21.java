// thinkinjavaex/chapter12/Ex21.java

class Exception211 extends Exception {}
class Exception212 extends Exception211 {}

class Base{
    Base() throws Exception211{
        throw new Exception211();
    }
}

class Derived extends Base{
    // public Base() extends Exception211{}
    Derived() throws Exception211{
        super();
        // 错误: 对super的调用必须是构造器中的第一个语句
        // try{
            // super();
        // }catch(Exception211 e){
            // System.out.println(e);
        // }
    }
}

public class Ex21{
    public static void main(String[] args){
        try{
            Derived d = new Derived();
        } catch(Exception211 e) {
            System.out.println("BaseException caught in main()");
        }
    }
}