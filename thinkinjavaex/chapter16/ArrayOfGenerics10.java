// thinkinjavaex/chapter16/ArrayOfGenerics10.java
import java.util.*;

public class ArrayOfGenerics10 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        List<List<String>> lls = new ArrayList<List<String>>();
        List<List> la = new ArrayList<List>();
        // warnings here
        // lls = (List<List<String>>)la;
        lls.add(new ArrayList<String>());
        
        List<Object> lo = new ArrayList<Object>();
        // lo = lls;
        
        List<List<BerylliumSphere>> spheres = 
            new ArrayList<List<BerylliumSphere>>();
        for(int i = 0; i<10; i++){
            spheres.add(new ArrayList<BerylliumSphere>());
            for(int j = 0; j < 2; j++)
                spheres.get(i).add(new BerylliumSphere());
        }
    }
}