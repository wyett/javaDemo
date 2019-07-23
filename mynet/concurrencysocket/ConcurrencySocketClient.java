package mynet.concurrencysocket;

import mynet.concurrencysocket.datadecorator.TalkModelAddStringDecorator;
import mynet.concurrencysocket.datadecorator.UserInfoAddStringDecorator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 19:13
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ConcurrencySocketClient {
    public static void main(String[] args) {
        String fname = "G:/java/idea/src/mynet/concurrencysocket/" +
                "master.properties";
        ReadProperties rp = new ReadProperties(fname);

        /** get variables */
        int remotePort = Integer.parseInt(rp.getItemValue("master_port"));
        int localPort = Integer.parseInt(rp.getItemValue("slave_port"));
        InetAddress localHost = null;
        InetAddress remoteHost = null;
        try {
            localHost = InetAddress.getLocalHost();
            remoteHost = InetAddress.getByName(rp.getItemValue("master_ip"));
        } catch(UnknownHostException ex) {}

        /** get input from console */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input delimited by space: ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println("ConcurrencySocketClient: " + input);
            new Thread(new ClientPointSocket<TalkModelAddStringDecorator>(
                    new TalkModelAddStringDecorator(input),
                    remoteHost, remotePort, localHost, localPort)).start();
        }
    }
}
