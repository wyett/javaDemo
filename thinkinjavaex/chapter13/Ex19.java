// thinkinjava/chapter13/Ex19.java

import java.util.regex.*;
import com.wyett.util.*;
import static com.wyett.util.Print.*;

public class Ex19{
    public static void main(String[] args) throws Exception{
        if(args.length < 1){
            print("Usage: input java filename");
            System.exit(0);
        }
        Pattern p = Pattern.compile("class \\w+\\s+");
        print("class in " + args[0]);
        int index = 0;
        Matcher m = p.matcher("");
        for(String line: new TextFile(args[0])){
            m.reset(line);
            while(m.find())
                print(m.group());
        }
    }
}