// thinkinjavaex/chapter15/Ex27.java
import java.util.*;

public class Ex27 {
    public static void main(String[] args){
        // 不兼容的类型: ArrayList<Integer>无法转换为List<Number>
        // List<Number> ln = new ArrayList<Integer>();
        List<? extends Number> lns = new ArrayList<Integer>();
        // 参数不匹配; Integer无法转换为CAP#1
        // lns.add(new Integer(0));
        lns.add(null);
        Number n = lns.get(0);
        System.out.println(n);
    }
}