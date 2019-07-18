// thinkinjavaex/chapter14/Ex10.java

public class Ex10{
    public static void main(String[] args){
        char[] s = new char[]{};
        System.out.println((s instanceof Object));
        System.out.println(s.getClass().getSuperclass());
    }
}