package mynet.concurrencysocket;

import java.util.Scanner;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 19:13
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ConcurrencySocketClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            new ClientPointSocket(input);
        }
    }
}
