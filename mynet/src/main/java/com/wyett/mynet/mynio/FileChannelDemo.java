package com.wyett.mynet.mynio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/27 17:16
 * @description:
 */

public class FileChannelDemo {
    /**
     * read from file, put it into channel, then into buf
     * @param file
     * @throws IOException
     */
    public void readFromFile(String file) throws IOException{
        RandomAccessFile aFile = new RandomAccessFile(file, "rw");
        FileChannel inChannel = aFile.getChannel();

        // create buffer with capacity of 64 bytes
        ByteBuffer buf = ByteBuffer.allocate(64);

        // read it into buffer
        int bytesRead = inChannel.read(buf);

        // print buf
        while(bytesRead != -1) {
            System.out.println("\nRead " + bytesRead);

            // change buf from write to read, read to read
            buf.flip();

            while(buf.hasRemaining()) {
                // read one byte at a time
                System.out.print((char) buf.get());
            }

            // make buffer read for writing
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
    @Test
    public void test() {
        try {
            readFromFile("G:\\java\\idea\\src\\mynet\\mynio\\FileChannelDemo.java");
        } catch(IOException ex) { }
    }
}
