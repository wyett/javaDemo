// com/wyett/util/OSExecute22.java
import java.io.*;
import java.util.*;
import com.wyett.util.*;

class OSExecute22 {
    public static List<String> command(String command){
        boolean err = false;
        List<String> ls = new LinkedList<String>();
        try {
            Process process = 
                new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine()) != null)
                ls.add(s);
            BufferedReader errors = new BufferedReader(
                new InputStreamReader(process.getErrorStream()));
            while((s = errors.readLine()) != null){
                System.out.println(s);
                err = true;
            }
        }catch(Exception e){
            if(!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        } 
        if(err)
            throw new OSExecuteException("Errors executing " +
                command);
        return ls;
    }
}
public class Ex22{
    public static void main(String[] args){
        List<String> result = 
            OSExecute22.command("javap Ex22");
        for(String s: result)
            System.out.println(s);
    }
}