// chinkinjava/chapter14/Ex14.java
import thinkinjava.chapter14.factory.*;
import java.util.*;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part>> partClasses =
        new ArrayList<Class<? extends Part>>();
    static {
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(CabinAirFilter.class);
        partClasses.add(OilFilter.class);
        partClasses.add(FanBelt.class);
        partClasses.add(PowerSteeringBelt.class);
        partClasses.add(GeneratorBelt.class);
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partClasses.size());
        try{
            return partClasses.get(n).newInstance();
        } catch(InstantiationException e) {
            throw new RuntimeException(e);
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
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

public class Ex14 {
    public static void main(String[] arg){
        for(int i=0; i<10; i++)
            System.out.println(Part.createRandom());
    }
}

