// thinkinjavaex/chapter15/Ex26.java

public class Ex26 {
    public static void main(String[] args){
        Number[] numbers = new Integer[3];
        numbers[0] = new Integer(0);
        numbers[1] = new Integer(1);
        numbers[2] = new Integer(2);
        // : 对于Integer(没有参数), 找不到合适的构造器
        // numbers[0] = new Integer();
        // java.lang.ArrayStoreException: java.lang.Double
        // try {
            // numbers[0] = new Double(3.4);
        // } catch(Exception e) {
            // System.out.println(e);
        // }
        // 不兼容的类型: Number[]无法转换为Integer[]
        for(Number number: numbers)
            System.out.println(number);
        // Integer[] ints = numbers;
        // for(Integer it: ints)
            // System.out.println(it);
        for(Number number: numbers)
            System.out.println(number.getClass().getSimpleName());
    }
}