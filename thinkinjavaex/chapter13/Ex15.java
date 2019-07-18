// thinkinjava/chapter13/Ex15.java

import java.util.regex.*;
import com.wyett.util.*;

public class Ex15{
    public static void main(String[] args) throws Exception{
        if(args.length < 3){
            System.out.println("Usage: \njava JGrep file regex");
            System.exit(0);
        }
        int flag = 0;
        if(args[2].equals("Pattern.CASE_INSENSITIVE"))
            flag = Pattern.CASE_INSENSITIVE;
        else if(args[2].equals("Pattern.MULTILINE"))
            flag = Pattern.MULTILINE;
        Pattern p = Pattern.compile(args[1], flag);
        int index = 0;
        Matcher m = p.matcher("");
        for(String line: new TextFile(args[0])){
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                    m.group() + ": " +m.start());
        }
    }
}