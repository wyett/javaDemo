// thinkinjava/chapter18/Ex01.java

import java.io.*;
import java.util.*;
import com.wyett.util.TextFile;

public class Ex01 {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private String ext = args[0].toLowerCase();
                public boolean accept(File dir, String name) {
                    System.out.println(dir + ", " + name);
                    if(name.toLowerCase().endsWith(ext)) {
                        if(args.length == 1)
                            return true;
                        Set<String> words = new HashSet<String> (
                            new TextFile(new File(
                                dir, name).getAbsolutePath(), "\\W+"));
                        for(int i = 1; i < args.length; i++)
                            if(words.contains(args[i]))
                                return true;
                    }
                    return false;
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem: list)
            System.out.println(dirItem);
        
    }
}