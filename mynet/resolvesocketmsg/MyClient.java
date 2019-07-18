package mynet.resolvesocketmsg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 11:50
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyClient {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100; i++) {
            Socket socket = null;
            ObjectOutputStream os = null;
            ObjectInputStream is = null;
            try {
                socket = new Socket("127.0.0.1", 10000);
                // output
                os = new ObjectOutputStream(socket.getOutputStream());
                User user = new User(
                        "user_" + i, "password_" + i);
                os.writeObject(user);
                os.flush();
                // input
                is = new ObjectInputStream(socket.getInputStream());
                Object obj = is.readObject();
                if(obj != null) {
                    user = (User) obj;
                    System.out.println("user: " + user.getName() +
                        ", password: " + user.getPassword());
                }
            } catch(IOException ex) {

            } finally {
                try {
                    os.close();
                    is.close();
                    socket.close();
                } catch(Exception ex) {}
            }
        }
    }
}
