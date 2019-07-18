// thinkinjavaex/chapter15/GenericMethods9.java

public class GenericMethods9 {
    // public <T, U, V> void f(T x, U y, V z){
        // System.out.println(x.getClass().getName() + '\n' +
            // y.getClass().getName() + '\n' +
            // z.getClass().getName() + '\n');
    // }
    public <A, B, C> void f(A x, B y, C z){
        System.out.println(x.getClass().getName() + '\n' +
            y.getClass().getName() + '\n' +
            z.getClass().getName() + '\n');
    }
    public static void main(String[] args){
        GenericMethods9 gm9 = new GenericMethods9();
        gm9.f(1, "", 'c');
    }
}