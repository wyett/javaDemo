// thinkinjavaex/chapter18/Ex20.java
import java.io.*;
import java.util.*;
import com.wyett.util.*;
import java.util.regex.*;

class ClassFileHeader{
    private static String path;
    private static String regex;
    private static byte[] sig =
        {(byte)202, (byte)254, (byte)186, (byte)190};
    ClassFileHeader(String path, String regex){
        this.path = path;
        this.regex = regex;
    }
    public static void checkHeader()
    throws IOException{
        for(File f: Directory.walk(path, regex)){
            // System.out.println(f);
            byte[] b = BinaryFile.read(f);
            for(int i = 0; i < sig.length; i++)
                if(b[i] != sig[i]){
                    System.err.println(f + " is corrupt!");
                }
        }
    }
}

public class Ex20 {
    public static void main(String[] args) 
    throws IOException{
        if(args.length != 2){
            System.err.println(
                "Usage: java Ex20 path regex");
        }else{
            ClassFileHeader cfh = 
                new ClassFileHeader(args[0], args[1]);
            cfh.checkHeader();
        }
    }   
}