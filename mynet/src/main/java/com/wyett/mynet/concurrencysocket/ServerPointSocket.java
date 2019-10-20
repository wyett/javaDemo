package com.wyett.mynet.concurrencysocket;

import com.wyett.mynet.concurrencysocket.datadecorator.TalkModelAddStringDecorator;
import com.wyett.mynet.concurrencysocket.datadecorator.UserInfoAddStringDecorator;
import com.wyett.mynet.concurrencysocket.datamodel.UserInfo;

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

public class ServerPointSocket<T> implements Runnable{
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
//            UserInfoAddStringDecorator userInfo =
//                    (UserInfoAddStringDecorator) obj;
//            System.out.println("ServerPointSocket: " + userInfo);
//            ReflectModel<UserInfoAddStringDecorator> reflectModel =
//                    new ReflectModel<UserInfoAddStringDecorator>();
            T t = (T) obj;
            System.out.println("ServerPointSocket: " + t);
            ReflectModel<T> reflectModel = new ReflectModel<T>();
            reflectModel.decode(t);
            os.writeObject(t);
            os.flush();
        } catch(IOException ex ) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch(Exception ex) {
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
