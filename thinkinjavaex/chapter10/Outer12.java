// thinkinjavaex.chapter10.Outer12.java

/* 通过外部类方法，返回内部类对象
public class Outer12 {
    private int i;
    private void f(){ System.out.println("Hi"); }
    class Inner {
        public void modifyOuter(int s){
            i = s;
            f();
        }
    }
    public Inner o12(){
        return new Inner();
    }
    public static void main(String[] args){
        Outer12 o = new Outer12();
        Outer12.Inner p = o.o12();
        p.modifyOuter(13);
        System.out.println(o.i);
    }
}
*/

/* 通过.new创建内部类对象
public class Outer12 {
    private int i;
    private void f() { System.out.println("Hi"); }
    class Inner {
        public void modifyOuter(int s){
            i = s;
            f();
        }
    }
    public static void main(String[] args){
        Outer12 o = new Outer12();
        Outer12.Inner p = o.new Inner();
        p.modifyOuter(13);
        System.out.println(o.i);
    }
}
*/

//通过匿名类
// abstract class Inner {
    // 错误: 缺少方法主体, 或声明抽象
    // void modifyOuter(){};
// }

interface Inner {
    void modifyOuter();
}

public class Outer12 {
    private int i;
    private void f() { System.out.println("Hi"); }
    public Inner oInner(final int s){
        return new Inner() {
            public void modifyOuter(){
                i = s;
                f();
            }
        };
    }
    public static void main(String[] args){
        Outer12 o = new Outer12();
        o.oInner(12).modifyOuter();
        System.out.println(o.i);
    }
}


















