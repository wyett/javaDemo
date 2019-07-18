// thinkinjavaex/chapter10/Ex18.java

public class Ex18 {
    Ex18() {
        System.out.println("Ex18 constructor");
    }
    public static class Ex18Nest1{
        Ex18Nest1(){System.out.println("Ex18Nest1 constructor"); }
    }
    public static class Ex18Nest2{
        Ex18Nest2(){System.out.println("Ex18Nest1 constructor"); }
    }
    public static void main(String[] args){
        Ex18Nest1 ex1 = new Ex18Nest1();
        Ex18Nest2 ex2 = new Ex18Nest2();
    }
}