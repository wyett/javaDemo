// thinkinjavaex/chapter13/Ex9.java

import java.util.*;

public class Ex9{
    public static String knights = 
        "Then, when you have found the shrubbery, you muse " +
        "cut down the mightiest tree in the forest..." +
        "with... a herring!";
    // public static void split(String regex){
        // System.out.println(
            // Arrays.toString(knights.split(regex)));
    // }
    // public static Character[] vowels = 
        // new Character[]{'A','E','I','O','U','a','e','i','o','u'};
    // public static void replaceVowel(){
        // for(Character c: vowels)
            // knights.replaceAll((String)c, "_");
        // System.out.println(knights);
    // }
    public static void main(String[] args){
        // replaceVowel();
        System.out.println(knights.replaceAll("[AEIOUaeiou]", "_"));
    }
}