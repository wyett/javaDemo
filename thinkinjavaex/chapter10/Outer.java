// thinkinjavaex/chapter10/Outer.java

public class Outer {
    class Inner {
        private int i = 10;
        Inner(int i) {
            this.i = i;
        }
        int readI() { return i; }
    }
    public Inner callInner(int x){
        return new Inner(x);
    }
    public static void main(String[] args){
        Outer o = new Outer();
        Outer.Inner s = o.callInner(100);
    }
}