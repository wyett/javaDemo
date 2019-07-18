import java.util.*;
import static com.wyett.util.Print.*;

public class Test{
    public static void main(String[] args){
        Map<Character, Integer> vc = 
            new TreeMap<Character, Integer>();
        vc.put('A', 0);
        print(vc.get('A'));
        int s = vc.get('A');
        vc.put('A', ++s);
        print(vc);
    }
}