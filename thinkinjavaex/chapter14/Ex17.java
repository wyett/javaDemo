// thinkinjavaex/chapter14/Ex17.java
import java.lang.reflect.*;
import java.util.regex.*;
import static com.wyett.util.Print.*;

public class Ex17 {
    private static String usage = 
        "usage:\n" +
        "Show Methods qualified.class.name\n" +
        "To show all methods in class or:\n" +
        "ShowMethods qualified class name word\n" +
        "To search for methods involving word";
    private static Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");
    public static void main(String[] args){
        if(args.length < 1){
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            print(c);
            print();
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if(args.length == 1){
                for(Method method : methods)
                    print(p.matcher(method.toString()).replaceAll(""));
                print("---------------------");
                for(Constructor ctor : ctors)
                    print(p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length + ctors.length;
            } else {
                for(Method method : methods)
                    if(method.toString().indexOf(args[1]) != -1){
                        print(
                        p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                print("+++++++++++++++++");
                for(Constructor ctor : ctors)
                    if(ctor.toString().indexOf(args[1]) != -1){
                        print(p.matcher(
                        ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        }catch(ClassNotFoundException e) {
            print("NO such class!" + e);
        }
        // for(int i=0; i< args.length; i++)
            // System.out.println(args[i]);
    }
}

/*
G:\java\thinkinjavaex\chapter14>java Ex17 Ex17
class Ex17

public static void main(String[])
public void wait() throws InterruptedException
public void wait(long,int) throws InterruptedException
public void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public int hashCode()
public Class getClass()
public void notify()
public void notifyAll()
---------------------
public Ex17()

*/