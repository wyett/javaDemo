package mynet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.wyett.util.Print.print;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/16 11:28
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ServerSocketDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket csocket = null;
//        InputStream in = null;
//        OutputStream out = null;
        BufferedReader in = null;
        int port = 5000;
        try {
            serverSocket = new ServerSocket(port);
            print("server socket started，waiting for connection...");
            csocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(
                    csocket.getInputStream()));
            while(true) {
                String str = in.readLine();
                print("client has send : " + str);
                Thread.sleep(2000);
            }
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
