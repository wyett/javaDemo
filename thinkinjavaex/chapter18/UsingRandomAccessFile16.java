// thinkinjava/chapter16/UsingRandomAccessFile16.java
import java.io.*;

public class UsingRandomAccessFile16 {
    static String fname = "Data.txt";
    static void display() throws IOException {
        RandomAccessFile in = new RandomAccessFile(fname, "r");
        for(int i = 0; i < 7; i ++)
            System.out.println(
                "Value " + i + ": " + in.readDouble());
        System.out.println(in.readUTF());
        in.close();
    }
    public static void main(String[] args)
    throws IOException {
        RandomAccessFile rf = new RandomAccessFile(fname, "rw");
        for(int i = 0; i < 7; i ++)
            rf.writeDouble(i*1.414);
        rf.writeUTF("end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(fname, "rw");
        rf.seek(5*8);
        rf.writeDouble(22.22);
        rf.close();
        display();
    }
}