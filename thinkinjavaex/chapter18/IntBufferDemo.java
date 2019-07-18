// thinkinjavaex/chapter18/DoubleBufferDemo.java
import java.nio.*;

public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        // store
        db.put(new double[]{11,42,47,99,143,811,1016});
        // absolute read and write
        System.out.println(db.get(3));
        db.put(3, 1811);
        db.flip();
        while(db.hasRemaining()){
            double i = db.get();
            System.out.println(i);
        }
    }
}