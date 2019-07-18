// thinkinjavaex/chapter15/StoringAndRecoveringData15.java
import java.io.*;
import static com.wyett.util.Print.*;

public class StoringAndRecoveringData15 {
    public static void main(String[] args)
    throws IOException {
        DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("data.txt")));
        // out.write(8);
        out.writeBoolean(true);
        out.writeByte(20);
        out.writeBytes("this is string");
        out.writeChar('t');
        out.writeChars("tsss");         
        out.writeDouble(1.11111);
        out.writeFloat(2.22222f);
        out.writeInt(40);
        out.writeLong(1000000000L);
        out.writeShort(50);
        out.writeUTF("this is utf");
        out.close();
        DataInputStream in = new DataInputStream(
            new BufferedInputStream(
                new FileInputStream("data.txt")));
        print(in.readBoolean());
        print(in.readByte());
        print(in.readUnsignedByte());
        print(in.readChar());
        // print(in.readChars());
        print(in.readDouble());
        print(in.readFloat());
        print(in.readInt());
        print(in.readLong());
        print(in.readUnsignedShort());
        print(in.readUTF());
    }
}
