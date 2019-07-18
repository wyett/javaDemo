// thinkinjavaex/chapter15/BasicGeneratorDemo14.java

import com.wyett.util.*;
// import thinkinjava.chapter15.CountedObject.*;

public class BasicGeneratorDemo14 {
    public static void main(String[] args) {
        Generator<CountedObject> gen = 
            new BasicGenerator<CountedObject>(CountedObject.class);
        // Generator<CountedObject> gen = 
            // BasicGenerator.create(CountedObject.class);
        for(int i=0; i<10; i++)
            System.out.println(gen.next());
    }
}