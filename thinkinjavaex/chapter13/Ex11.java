// thinkinjavaex/chapter13/Ex11.java

import java.util.regex.*;
import static com.wyett.util.Print.*;

public class Ex11 {
    public static void main(String[] args){
        if(args.length<2){
            print("Usage: \n test Ex11" +
                "characterSequence regulerException+");
            System.exit(0);
        }
        print("Input: \"" + args[0] + "\"");
        for(String arg: args){
            print("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            if(!m.find()) 
                print("No match found for " + "\"" + arg + "\"");
            m.reset();
            if(m.find()){
                print("Match \"" + m.group() + "\" at position " +
                    m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
            }
        }
    }
}

/*
java Ex11 "Arline are eight apples and one orange while Anita hadn't any" "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"

Input: "Arline are eight apples and one orange while Anita hadn't any"
Regular expression: "Arline are eight apples and one orange while Anita hadn't any"
Match "Arline are eight apples and one orange while Anita hadn't any" at position 0-60
Regular expression: "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
Match "Arline" at position 0-5


*/