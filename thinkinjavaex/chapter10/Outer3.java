// thinkinjavaex/chapter10/Outer3.java

public class Outer3 {
    private String s;
    public Outer3(String x){ this.s = x; }
    class Inner {
        private int i = 10;
        Inner(int i) {
            this.i = i;
        }
        int readI() { return i; }
        public String toString() { return s; }
    }
    public Inner callInner(int x){
        return new Inner(x);
    }
    public static void main(String[] args){
        // Outer o = new Outer(10);
        // Outer.Inner s = o.callInner(100);
        Outer3 o = new Outer3("abc");
        Outer3.Inner s = o.callInner(100);
        System.out.println(s.readI());
        System.out.println(s.toString());
    }
}