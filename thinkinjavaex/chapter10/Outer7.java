// thinkinjavaex.chapter10.Outer7.java

class Outer7 {
    private int oi = 1;
    private void sayHi() { System.out.println("Hi"); }
    class Inner7 {
        void modifyOuter7(){
            oi *= 2;
            sayHi();
        }
    }
    public void showOi() { System.out.println(oi); }
    void testInner(){
        Inner7 s = new Inner7();
        s.modifyOuter7();
    }
    public static void main(String[] args){
        Outer7 o = new Outer7();
        o.showOi();
        o.testInner();
        o.showOi();
    }
}