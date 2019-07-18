// thinkinjavaex/chapter15/ClassTypeCapture21.java

class Building {}
class House extends Building {}

public class ClassTypeCapture21<T> {
    Class<T> kind;
    Map<String, Class<T>> msc;
    public ClassTypeCapture21(Class<T> kind) {
        this.kind = kind;
    }
    public ClassTypeCapture21(Class<T> kind, Map<String, Class<T>> map) {
        this.kind = kind;
        this.msc = map;
    }
    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static  addType(String typename, Class<T> kind){
        msc.put(typename, kind);
    }
	public Object createNew(String typename) 
		throws IllegalAccessException, InstantiationException {
		if(map.containsKey(typename))
			return map.get(typename).newInstance();			
		System.out.println(typename + " class not available");
		return null;
	}
    
    public static void main(String[] args){
        ClassTypeCapture21<Building> ctt1 =
            new ClassTypeCapture21<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture21<House> ctt2 =
            new ClassTypeCapture21<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}