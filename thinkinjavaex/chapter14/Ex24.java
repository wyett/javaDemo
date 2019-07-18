// chinkinjava/chapter14/Ex24.java
import thinkinjava.chapter14.factory.*;
import com.wyett.util.*;
import java.util.*;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactory =
        new ArrayList<Factory<? extends Part>>();
    static {
        partFactory.add(new FuelFilter.Factory());
        partFactory.add(new AirFilter.Factory());
        partFactory.add(new CabinAirFilter.Factory());
        partFactory.add(new OilFilter.Factory());
        partFactory.add(new FanBelt.Factory());
        partFactory.add(new PowerSteeringBelt.Factory());
        partFactory.add(new GeneratorBelt.Factory());
        partFactory.add(new NullPart.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactory.size());
        return partFactory.get(n).create();
    }
}

class NullPart extends Part implements Null{
    private NullPart() { super(); }
    public static final Part NULL = new NullPart();
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<NullPart>{
        public NullPart create(){
            return new NullPart();
        }
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<FuelFilter>{
        public FuelFilter create(){
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<AirFilter>{
        public AirFilter create(){
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<CabinAirFilter>{
        public CabinAirFilter create(){
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<OilFilter>{
        public OilFilter create(){
            return new OilFilter();
        }
    }
}

class FanBelt extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<FanBelt>{
        public FanBelt create(){
            return new FanBelt();
        }
    }
}

class PowerSteeringBelt extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<PowerSteeringBelt>{
        public PowerSteeringBelt create(){
            return new PowerSteeringBelt();
        }
    }
}

class GeneratorBelt extends Filter {
    public static class Factory
    implements thinkinjava.chapter14.factory.Factory<GeneratorBelt>{
        public GeneratorBelt create(){
            return new GeneratorBelt();
        }
    }
}

public class Ex24 {
    public static void main(String[] arg){
        for(int i=0; i<10; i++)
            System.out.println(Part.createRandom());
    }
}

