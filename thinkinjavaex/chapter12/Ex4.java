// thinkinjavaex/chapter12/Ex4.java

class Exception4 extends Exception {
    private String s = null;
    public Exception4(String str){
        super(str);
        this.s = str;
    }
    public void printStr(){
        System.out.println(s);
    }
}

public class Ex4 {
    public static void f() throws Exception4{
        // Exception4 e4 = new Exception4("");
        throw new Exception4("Test Exception4");
    }
    public static void main(String[] args){
        try{
            f();
        }catch (Exception4 e){
            System.out.println(e);
            e.printStr();
        }
    }
}