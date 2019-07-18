// thinkinjavaex.chapter10.Outer8

class Outer8 {
    class Inner8 {
        private int ii1 = 1;
        private int ii2 = 2;
        private void showIi2(){ System.out.println(ii2); }
        private void hi(){ System.out.println("Hi"); }
    }
    int oi = new Inner8().ii1;
    void showIi2(){ new Inner8().showIi2(); }
    void outerHi(){ new Inner8().hi(); }
    public static void main(String[] args){
        Outer8 o = new Outer8();
        System.out.println(o.oi);
        o.showIi2();
        o.outerHi();
    }
}