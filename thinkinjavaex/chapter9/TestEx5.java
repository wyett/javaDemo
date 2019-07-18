import thinkinjavaex.chapter9.ex5.*;
import static com.wyett.util.Print.*;

public class TestEx5 implements Ex5 {
    public void sayOne() { print("One"); }
    public void sayTwo() { print("Two"); }
    public void sayThree() { print("Three"); }
    public static void main(String[] args){
        TestEx5 x = new TestEx5();
        x.sayOne();
        x.sayTwo();
        x.sayThree();
    }
}