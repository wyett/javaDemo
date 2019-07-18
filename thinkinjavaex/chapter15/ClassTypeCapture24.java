// thinkinjavaex/chapter15/ClassTypeCapture24.java

import java.util.*;
import static com.wyett.util.Print.*;

interface Factory<T> {
    T create();
}

class Building {}
class House extends Building {}

class BuildingFactory implements Factory<Building> {
    public Building create(){
        return new Building();
    }
}

class HouseFactory implements Factory<House> {
    public House create(){
        return new House();
    }
}


public class ClassTypeCapture24<T> {
    Class<?> kind;
    public ClassTypeCapture24(Class<?> kind) {
        this.kind = kind;
    }
    
    Map<String, Factory> msc;
    public ClassTypeCapture24(Class<?> kind, Map<String, Factory> map) {
        this.kind = kind;
        this.msc = map;
    }
    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public void  addType(String typename, Factory factory){
        msc.put(typename, factory);
    }
    public Object createNew(String typename) 
        throws IllegalAccessException, InstantiationException {
        if(msc.containsKey(typename))
            return msc.get(typename).create();            
        System.out.println(typename + " class not available");
        return null;
    }
    
    public static void main(String[] args){
        ClassTypeCapture24<Building> ctt1 =
            new ClassTypeCapture24<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture24<House> ctt2 =
            new ClassTypeCapture24<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
        ClassTypeCapture24<Building> ct = 
        new ClassTypeCapture24<Building>(
            Building.class, new HashMap<String,Factory>());
        ct.addType("House", new HouseFactory());
        ct.addType("Building", new BuildingFactory());
        print("ct.map = " + ct.msc);
        try {
            Building b = (Building)ct.createNew("Building");
            House h = (House)ct.createNew("House");
            print("b.getClass().getName(): ");
            print(b.getClass().getName());
            print("h.getClass().getName(): ");
            print(h.getClass().getName());
            print("House h is instance House: ");
            print(h instanceof House);
            print("House h is instance of Building: ");
            print(h instanceof Building);
            print("Building b is instance of House: ");
            print(b instanceof House);
            ct.createNew("String");  // String class not available
        } catch(IllegalAccessException e) {
            print("IllegalAccessException in main");
        } catch(InstantiationException e) {
            print("InstantiationException in main");
        }        
    }
    
}