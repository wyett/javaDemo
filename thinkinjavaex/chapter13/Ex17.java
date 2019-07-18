// thinkinjavaex/chapter13/Ex17.java

import java.util.regex.*;
import static com.wyett.util.Print.*;
/*  test comment
    test
 */
public class Ex17{
    //test comment 1
    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            print("Usage: Input file name");
            System.exit(0);
        }
        Pattern p = Pattern.compile("(//\\s.+)|(/\\*\\s+.+)|(\\*\\s+.+)");
        int index = 0;
        Matcher m = p.matcher("");
        print(args[0] + "comments: ");
        for(String line: new TextFile(args[0]))
            m.reset(line);
            while(m.find())
                print(index++ + " : " + m.group());
    }
}