package mynet.netty.OIODemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/30 11:01
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class PlainOioServer {
    public void serve(int port) throws IOException{
        ServerSocket sc = new ServerSocket(port);
        try {
            for(;;) {
                Socket cs = sc.accept();
                System.out.println("Accepted connection from " + cs);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = cs.getOutputStream();
                            out.write("Hi!\r\n".getBytes(
                                    Charset.forName("UTF-8")));
                            out.flush();
                            cs.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                cs.close();
                            } catch(IOException e) {

                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
