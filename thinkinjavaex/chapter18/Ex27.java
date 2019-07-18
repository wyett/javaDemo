// thinkinjavaex/chapter18/Ex27.java
import java.io.*;
import static com.wyett.util.Print.*;

class ClassASerializable implements Serializable {
    private int n;
    public ClassASerializable(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}

class ClassBSerializable implements Serializable {
    private ClassASerializable next;
    public ClassBSerializable(int id) { 
        this.next = new ClassASerializable(id);
    }
    public String toString() {
        StringBuilder result = 
            new StringBuilder(
                "ClassASerializable(ClassBSerializable(");
        result.append(next);
        result.append("))");
        return result.toString();
    }
}

public class Ex27 {
    public static void main(String[] args)
    throws ClassNotFoundException, IOException{
        ClassBSerializable cb = 
            new ClassBSerializable(1);
        print("cb = " + cb);
        ObjectOutputStream out = 
            new ObjectOutputStream(
                new FileOutputStream("CB.out"));
        out.writeObject("ClassBSerializable storage\n");
        out.writeObject(cb);
        // also flushes output
        out.close();
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("CB.out"));
        String s = (String)in.readObject();
        ClassBSerializable cb1 = 
            (ClassBSerializable)in.readObject();
        print(s + "cb1 = " + cb1);
        //ByteArray
        ByteArrayOutputStream bout = 
            new ByteArrayOutputStream();
        ObjectOutputStream out2 =
            new ObjectOutputStream(bout);
        out2.writeObject("ClassBSerializable storage\n");
        out2.writeObject(cb);
        out2.flush();
        ObjectInputStream in2 = 
            new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        ClassBSerializable cb2 = (ClassBSerializable)in2.readObject();
        print(s + "cb2 = " + cb2);
    }
}








