// thinkinjavaex/chapter16/Ex18.java

import java.util.*;

public class Ex18 {
    public static void main(String[] args){
        BerylliumSphere[] bs = new BerylliumSphere[5];
        for(int i = 0; i < bs.length; i++)
            bs[i] = new BerylliumSphere();
        // Arrays.fill(bs, new BerylliumSphere());
        System.out.println(Arrays.toString(bs));
        BerylliumSphere[] bs1 = new BerylliumSphere[5];
        System.out.println(Arrays.toString(bs1));
        System.arraycopy(bs, 0, bs1, 0, bs.length);
        System.out.println(Arrays.toString(bs1));
    }
}