package mynet.concurrencysocket;

import mynet.concurrencysocket.datadecorator.UserInfoAddStringDecorator;
import mynet.concurrencysocket.datamodel.UserInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 16:39
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ServerPointSocket implements Runnable{
    private Socket svsocket;
    public ServerPointSocket(Socket sock) {
        this.svsocket = sock;
    }
    public void run() {
        ObjectInputStream is = null;
        ObjectOutputStream os = null;
        try {
            // input...
            is = new ObjectInputStream(svsocket.getInputStream());
            System.out.println("current thread: " + Thread.currentThread());
            Object obj = is.readObject();

            // output...
            os = new ObjectOutputStream(svsocket.getOutputStream());
            UserInfoAddStringDecorator userInfo =
                    (UserInfoAddStringDecorator) obj;
            ReflectModel<UserInfoAddStringDecorator> user =
                    new ReflectModel<UserInfoAddStringDecorator>();
            user.decode(userInfo);
            os.writeObject(userInfo);
            os.flush();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                svsocket.close();
            } catch(Exception ex) {}
        }
    }

}
