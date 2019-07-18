// thinkinjavaex/chapter11/AddTest.java

import java.util.*;
import static com.wyett.util.Print.*;

public class AddTest{
    public static void main(String[] args){
        Integer[] iii = new Integer[]{1,2,3};
        Integer a = iii[0];
        print(add(iii[1], iii[2]));
        print(a.add(iii[0], iii[1]));
    }
}