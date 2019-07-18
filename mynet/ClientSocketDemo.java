package mynet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.wyett.util.Print.print;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/16 12:26
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ClientSocketDemo {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String serverIP = "127.0.0.1";
        int port = 5000;
        try {
            socket = new Socket(serverIP, port);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            while(true) {
                int number = (int)(Math.random()*10) + 1;
                print("clent is sending: " + number);
                out.println(number);
                Thread.sleep(1000);
            }
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
