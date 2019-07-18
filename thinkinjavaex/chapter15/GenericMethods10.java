// thinkinjavaex/chapter15/GenericMethods10.java

public class GenericMethods10 {
    // public <T, U> void f(T x, U y, Character z){
        // System.out.println(x.getClass().getName() + '\n' +
            // y.getClass().getName() + '\n' +
            // z.getClass().getName() + '\n');
    // }
    public <T, U> void f(T x, U y, char z){
        System.out.println(x.getClass().getName() + '\n' +
            y.getClass().getName() + '\n' +
            z + '\n');
    }
    public static void main(String[] args){
        GenericMethods9 gm9 = new GenericMethods9();
        gm9.f(1, "", 'c');
    }
}
