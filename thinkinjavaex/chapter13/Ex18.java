// thinkinjavaex/chapter13/Ex18.java

import java.util.regex.*;
import static com.wyett.util.Print.*;
/*  test comment
    test
 */
public class Ex18{
    //test comment 1
    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            print("Usage: Input file name");
            System.exit(0);
        }
        Pattern p = Pattern.compile("\".*\"");
        // Pattern p = Pattern.compile("\".*\"");
        int index = 0;
        Matcher m = p.matcher("");
        print(args[0] + "comments: ");
        for(String line: new TextFile(args[0]))
            m.reset(line);
            while(m.find())
                print(index++ + " : " + m.group());
    }
}