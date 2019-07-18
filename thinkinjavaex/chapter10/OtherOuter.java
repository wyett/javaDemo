// thinkinjavaex.chapter10.OtherOuter.java

class Outer {
    class Inner{
        Inner(){
            System.out.println("Outer.Inner()");
        }
    }
}

public class OtherOuter {
    public static void main(String[] args){
        Outer o = new Outer();
        Outer.Inner p = o.new Inner();
    }
}