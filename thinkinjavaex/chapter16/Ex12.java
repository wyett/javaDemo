// thinkinavaex/chapter16/Ex12.java
import java.util.*;
import com.wyett.util.*;

public class Ex12 {
    public static void main(String[] args){
        double[] da = new double[10];
        CountingGenerator.Double doubleTest = 
            new CountingGenerator.Double();
        for(int i = 0; i< da.length; i++)
            da[i] = doubleTest.next();
        System.out.println(Arrays.toString(da));
    }
}