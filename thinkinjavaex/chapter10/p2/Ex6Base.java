// thinkinjavaex/chapter10/p2/ex6Interface

package thinkinjavaex.chapter10.p2;
import thinkinjavaex.chapter10.p1.Ex6Interface;

public class Ex6Base {
    protected class Ex6BaseInner implements Ex6Interface {
        public Ex6BaseInner(){}
        public String say() { return "Hi"; }
    }
}