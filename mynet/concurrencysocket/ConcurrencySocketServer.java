package mynet.concurrencysocket;

import mynet.concurrencysocket.datadecorator.TalkModelAddStringDecorator;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 14:49
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ConcurrencySocketServer {
    private static final int backlog = 200;
    public static void main(String[] args) {
        ReadProperties rp = new ReadProperties
                ("G:/java/idea/src/mynet/concurrencysocket/" +
                        "master.properties");
        ServerSocket serverSocket = null;
        Socket socket = null;

        // get hostip
        InetAddress host = null;
        try {
            host = InetAddress.getByName(rp.getItemValue("master_ip"));
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        // get port
        int port = Integer.parseInt(rp.getItemValue("master_port"));

        try {
            serverSocket = new ServerSocket(port, backlog, host);
            ExecutorService exec = Executors.newFixedThreadPool(5);
            while (true) {
                socket = serverSocket.accept();
                exec.execute(
                        new ServerPointSocket<TalkModelAddStringDecorator>(socket));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
