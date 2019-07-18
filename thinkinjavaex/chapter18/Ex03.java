// thinkinjavaex/chapter18/Ex03.java
import java.util.*;
import java.io.*;
import java.util.regex.*;
import static com.wyett.util.Print.*;

public class Ex03{
    public static void main(final String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter(){
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name){
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for( String listItem: list)
            System.out.println(listItem);
        print("=====================");
        long total = 0;
        long fs;
        for(String dirItem: list){
            fs = new File(path, dirItem).length();
            print(dirItem + ", " + fs + " bytes");
            total += fs;
        }
        print("=====================");
        print(list.length + " file(s), " + total + " bytes");
            
    }
}