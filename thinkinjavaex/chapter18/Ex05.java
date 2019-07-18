// thinkinjava/chapter18/Ex05.java

import java.io.*;
import com.wyett.util.*;

class ProcessFiles05 {
    public interface Strategy{
        void process(File file);
    }
    private Strategy strategy;
    private String regex;
    public ProcessFiles05(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }
    public void start(String[] args) {
        try {
            if(args.length == 0)
                processDirectoryTree(new File("."));
            for(String arg : args) {
                File fileArg = new File(arg);
                if(fileArg.isDirectory())
                    processDirectoryTree(fileArg);
                else
                    if(arg.matches(regex))
                        strategy.process(fileArg.getCanonicalFile());
                
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void 
    processDirectoryTree(File root) throws IOException {
        for(File file : Directory.walk(
            root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }
}
public class Ex05 {
    public static void main(String[] args) {
        new ProcessFiles05(new ProcessFiles05.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*\\.java").start(args);
    }
}