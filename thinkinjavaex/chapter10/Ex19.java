// thinkinjavaex/chapter10/Ex19.java
import static com.wyett.util.Print.*;

public class Ex19 {
    Ex19() { print("Ex19() constructor"); }
    private class Ex19Inner {
        Ex19Inner(){
            print("Ex19Inner constructor");
        }
        private class Ex19InnerInner {
            Ex19InnerInner() {
                print("Ex19InnerInner constructor");
            }
        }
    }
    private static class Ex19Nester {
        Ex19Nester() {
            print("Ex19Nester constructor");
        }
        private static class Ex19NesterNester {
            Ex19NesterNester(){
                print("Ex19NesterNester constructor");
            }
        }
    }
    public static void main(String[] args){
        // 无法从静态上下文中引用非静态 变量 this, Ex19Nester必须是static
        // Ex19Nester nest = new Ex19Nester();
        Ex19Nester nest = new Ex19Nester();
        Ex19Nester.Ex19NesterNester nest1 = new Ex19Nester.Ex19NesterNester();
        Ex19 e = new Ex19();
        // 无法从静态上下文中引用非静态 变量 this
        // Ex19.Ex19Inner e1 = new Ex19.Ex19Inner();
        Ex19.Ex19Inner e1 = e.new Ex19Inner();
        Ex19.Ex19Inner.Ex19InnerInner e2 = e1.new Ex19InnerInner();
    }
}
