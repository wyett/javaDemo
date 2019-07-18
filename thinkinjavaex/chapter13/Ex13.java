// thinkinjavaex/chapter13/Ex13.java

import java.util.regex.*;
import static com.wyett.util.Print.*;

public class Ex13{
    public static String input = 
        "Twas brillig. and the slithy toves\n" +
        "Did gyre and gimble in the wabe.\n" +
        "All mimsy were the borogoves,\n" +
        "And the mome raths outgrabe.\n\n" +
        "Beware the Jabberwock, my som, \n" +
        "The jaws that bite, the claws that catch.\n" +
        "Beware the Jubjub bired, and shun\n" +
        "The freuious Bandersnatch.";
    
    private static class Display {
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex){ this.regex = regex; }
        void display(String message){
            if(!regexPrinted){
                print(regex);
                regexPrinted = true;
            }
            print(message);
        }
    }
    static void examine(String s, String regex){
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while(m.find())
            d.display("find() '" + m.group() +
                "' start = " + m.start() + "end = " + m.end());
        if(m.lookingAt())
            d.display("lookingAt() start = " +
                m.start() + " end = " + m.end());
        if(m.matches())
            d.display("matches() start = " +
                m.start() + " end = " + m.end());
    }
    
    public static void main(String[] args){
        for(String in: input.split("\n")){
            print("input: " + in);
            for(String regex : new String[]{"\\w*ere\\w*",
                "A\\w+", "T\\w+", "Did.*?!"})
                examine(in, regex);
        }
    }
}

/*

input: Twas brillig. and the slithy toves
T\w+
find() 'Twas' start = 0end = 4
lookingAt() start = 0 end = 4
input: Did gyre and gimble in the wabe.
input: All mimsy were the borogoves,
\w*ere\w*
find() 'were' start = 10end = 14
input: And the mome raths outgrabe.
input: 
input: Beware the Jabberwock, my som, 
input: The jaws that bite, the claws that catch.
T\w+
find() 'The' start = 0end = 3
lookingAt() start = 0 end = 3
input: Beware the Jubjub bired, and shun
input: The freuious Bandersnatch.
T\w+
find() 'The' start = 0end = 3
lookingAt() start = 0 end = 3

*/