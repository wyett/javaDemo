// thinkinjava/chapter18/Ex19.java
import java.io.*;
import java.util.*;
import com.wyett.util.*;

public class Ex19{
    public static void main(String[] args) throws IOException{
        Map<Byte, Integer> mbi = new HashMap<Byte, Integer>();
        if(args.length != 1){
            System.err.println(
                "Usage: java Ex19 fname");
        }else{
            byte[] b = BinaryFile.read(args[0]);
            for(Byte b1: b){
                Integer freq = mbi.get(b1);
                mbi.put(b1, freq == null ? 1 : freq + 1);
            }
        }
        //System.out.println(Arrays.toString(b));
        List<Byte> keys = 
            new ArrayList<Byte>(mbi.keySet());
        Collections.sort(keys);
        for(Byte key: keys)
            System.out.println(key + " => " + mbi.get(key));
    }
}