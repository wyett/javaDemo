// thinkinjavaex/chapter16/TestArrayGenerator.java

import java.util.*;
import com.wyett.util.*;
import static com.wyett.util.Print.*;

public class TestArrayGenerator {
    public static void main(String[] args) {
        int size = 7;
        int skip = 2;
        boolean[] a1 = ConvertTo.primitive(Generated.array(
            new Boolean[size], new SkipGeneratorClass.Boolean(skip), skip));
        System.out.println("a1: " + Arrays.toString(a1));
        byte[] a2 = ConvertTo.primitive(Generated.array(
            new Byte[size], new SkipGeneratorClass.Byte(skip), skip));
        System.out.println("a2: " + Arrays.toString(a1));
    }
}