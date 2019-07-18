// thinkinjavaex/chapter10/Cycles.java


import static com.wyett.util.Print.*;

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public void ride() { print("Unicycle()"); }
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle(){
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    public void ride() { print("Bicycle()"); }
}

class BincycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {
    public Tricycle() { print("Tricycle constructor"); }
    public void ride() { print("Tricycle()"); }
}

class TricycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }
    public static void main(String[] args){
        rideCycle(new UnicycleFactory());
        rideCycle(new BincycleFactory());
        rideCycle(new TricycleFactory());
    }
}

