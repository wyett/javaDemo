// thinkinjava/chapter13/Ex20.java
import java.util.*;

public class Ex20{
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;
    Ex20(String s){
        Scanner sc = new Scanner(s);
        i = sc.nextInt();
        l = sc.nextLong();
        f = sc.nextFloat();
        d = sc.nextDouble();
        this.s = sc.next();
    }
    public String toString(){
        return i + " " + l + " " + f + " " + d;
    }
    public static void main(String[] args){
        Ex20 e = new Ex20("17 56789 2.7 3.61412 hello");
        System.out.println(e);
    }
}