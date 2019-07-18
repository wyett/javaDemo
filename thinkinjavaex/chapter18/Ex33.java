// thinkinjava/chapter18/Ex33.java
import java.util.*;
import java.util.prefs.*;
import static com.wyett.util.Print.*;

public class Ex33 {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences
            .userNodeForPackage(Ex33.class);
        String directory = 
            prefs.get("base directory", "Not defined");
        print("directory:" + directory);
        Scanner sc = new Scanner(System.in);
        printnb("Entry a new directory:");
        prefs.put("base directory", directory);
        print("\ndirectory: " + directory);
    }
}