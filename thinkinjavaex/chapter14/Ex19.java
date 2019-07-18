// thinkinjavaex/chapter14/Ex19.java
// package thinkinjavaex.chapter14;
import static com.wyett.util.Print.*;
import java.lang.reflect.*;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {
        print("default construnctor");
    }
    Toy(int i) {
        print("constructor number " + i);
    }
}

class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1); }
}

public class Ex19 {
    // static void printInfo(Class cc) {
        // print("Class name: " + cc.getName() +
            // " is interface? [" +cc.isInterface());
        // print("Simple name: " + cc.getSimpleName());
        // print("Canonical name: " + cc.getCanonicalName());
    // }
    public static void main(String[] args){
        try{
            Toy.class.getDeclaredConstructor(int.class).newInstance(1);
        }catch(NoSuchMethodException e){
            print("No Such Exception: " + e);
        }catch(InstantiationException e){
            print("Unable to make Toy: " + e);
        }catch(IllegalAccessException e){
            print("Unable access: " + e);
        }catch(InvocationTargetException e){
            print("Target Invocation problem: " + e);
        }
    }
}