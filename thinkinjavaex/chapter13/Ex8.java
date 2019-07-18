// thinkinjavaex/chapter13/Ex8.java

import java.util.*;

public class Ex8{
    public static String knights = 
        "Then, when you have found the shrubbery, you muse " +
        "cut down the mightiest tree in the forest..." +
        "with... a herring!";
    public static void split(String regex){
        System.out.println(
            Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args){
        split("the|you");
    }
}