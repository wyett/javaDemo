// thinkinjavaex/chapter18/Ex02.java
import java.util.*;
import java.util.regex.*;
import java.io.*;
import static com.wyett.util.Print.*;

class SortedDirList {
    private File dirname;
    public SortedDirList() { dirname = new File("."); }
    public SortedDirList(File dirname) { this.dirname = dirname;    }
    public String[] list() {
        String[] list = dirname.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
    public String[] list(final String fn_regex) {
        String[] list = 
            dirname.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(fn_regex);
                public boolean accept(File dir, String name){
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
}

public class Ex02 {
    public static void main(String[] args){
        SortedDirList dir = new SortedDirList();
        print(Arrays.asList(dir.list("Ex0[12].*\\.java")));
    }
}