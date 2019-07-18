// thinkinjava/chapter13/Ex16.java

import java.util.regex.*;
import com.wyett.util.*;

public class Ex16{
    public static void main(String[] args) throws Exception{
        if(args.length < 2){
            System.out.println("Usage: \njava JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        if(args[0])
        for(String line: new TextFile(args[0])){
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                    m.group() + ": " +m.start());
        }
    }
}