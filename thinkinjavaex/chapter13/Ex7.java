// thinkinjava/chapter13/Ex7.java
import java.util.*;

public class Ex7{
    public static String knights = 
        "Then, when you have found the shrubbery, you muse " +
        "cut down the mightiest tree in the forest..." +
        "with... a herring.";
    public static void getString(String s){
        System.out.println(s.matches("^[A-Z].*[\\.]$"));
    }
    public static void main(String[] args){
        getString(knights);
    }
}