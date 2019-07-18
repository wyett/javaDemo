// thinkinjavaex/chapter14/Ex18.java
import java.lang.reflect.*;
import java.util.regex.*;
import static com.wyett.util.Print.*;

class Ex18 {
    private static String usage = 
        "usage:\n" +
        "Show Methods qualified.class.name\n" +
        "To show all methods in class or:\n" +
        "ShowMethods qualified class name word\n" +
        "To search for methods involving word";
    private static Pattern p = Pattern.compile("\\w+\\.");
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
G:\java\thinkinjavaex\chapter14>java Ex18 Ex18
class Ex18

public static void main(String[])
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
---------------------


*/

