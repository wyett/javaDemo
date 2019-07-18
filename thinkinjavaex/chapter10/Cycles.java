// thinkinjavaex/chapter10/Cycles.java

import static com.wyett.util.Print.*;

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public void ride() { print("Unicycle"); }
    public static CycleFactory factory = 
        new CycleFactory() {
            public Cycle getCycle() {
                return new Unicycle();
            }
        };
}

class Bicycle implements Cycle {
    public void ride() { print("Bicycle()"); }
    public static CycleFactory factory = 
        new CycleFactory() {
            public Cycle getCycle(){
                return new Bicycle();
            }
        };
}

class Tricycle implements Cycle {
    public void ride() { print("Tricycle()"); }
    public static CycleFactory factory = 
        new CycleFactory() {
            public Cycle getCycle() {
                return new Tricycle();
            }
        };
}


public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }
    public static void main(String[] args){
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }
}


