// thinkinjavaex/chapter10/p3/ex6Interface

import thinkinjavaex.chapter10.p1.Ex6Interface;
import thinkinjavaex.chapter10.p2.Ex6Base;

public class Ex6 extends Ex6Base {
    Ex6Interface getBaseInner(){
        return this.new Ex6BaseInner();
    }
    public static void main(String[] args){
        Ex6 e = new Ex6();
        System.out.println(e.getBaseInner().say());
    }
}