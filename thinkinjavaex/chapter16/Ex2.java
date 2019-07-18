// thinkinjavaex/chapter16/Ex2.java
import java.util.*;
import static com.wyett.util.Print.*;

public class Ex2{
    public static BerylliumSphere[] getBe(int n){
        BerylliumSphere[] b = new BerylliumSphere[n];
        for(int i=0;i< n; i++)
            b[i] = new BerylliumSphere();
        return b;
        // return new BerlliumSphere[n];
    }
    public static void main(String[] args){
        for(int i = 0; i<10; i++)
            print(Arrays.asList(getBe(3)));
        
    }
}