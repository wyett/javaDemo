//thinkinjavaex/chapter13/Ex12.java

import java.util.*;
import java.util.regex.*;
import static com.wyett.util.Print.*;

public class Ex12{
    static public final String POEM = 
        "Twas brillig. and the slithy toves\n" +
        "Did gyre and gimble in the wabe.\n" +
        "All mimsy were the borogoves,\n" +
        "And the mome raths outgrabe.\n\n" +
        "Beware the Jabberwock, my som, \n" +
        "The jaws that bite, the claws that catch.\n" +
        "Beware the Jubjub bired, and shun\n" +
        "The freuious Bandersnatch.";
    public static void main(String[] args){
        Matcher m = 
    Pattern.compile("(^[a-z]|\\s+[a-z])\\w+")
            .matcher(POEM);
        Set<String> ss = new TreeSet<String>();
        while(m.find()){
            ss.add(m.group());
        }
        print(ss);
        print();
    }
}