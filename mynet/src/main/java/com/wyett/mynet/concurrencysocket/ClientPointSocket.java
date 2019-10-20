package com.wyett.mynet.concurrencysocket;

import com.wyett.mynet.concurrencysocket.datadecorator.UserInfoAddStringDecorator;
import com.wyett.mynet.concurrencysocket.datamodel.UserInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 21:19
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ClientPointSocket<T> implements Runnable{
    private T t;
    private InetAddress remoteHost;
    private int remotePort;
    private InetAddress localHost;
    private int localPort;
    public ClientPointSocket(T t, InetAddress remoteHost,
                             int remotePort,
                             InetAddress localHost,
                             int localPort) {
        this.t = t;
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
        this.localHost = localHost;
        this.localPort = localPort;
//        System.out.println(t);
    }
    @Override
    public void run() {
        Socket socket = null;
        ObjectInputStream is = null;
        ObjectOutputStream os = null;
        try {
            // output
            System.out.println(t);
            System.out.println("===========");
            socket = new Socket(remoteHost, remotePort, localHost, localPort);
            os = new ObjectOutputStream(socket.getOutputStream());
            ReflectModel<T> reflectModel = new ReflectModel<T>();
            reflectModel.encode(t);
            os.writeObject(t);
            os.flush();

            // input
            is = new ObjectInputStream(socket.getInputStream());
            System.out.println(is.readObject());
            Object obj = is.readObject();

            if(obj != null) {
                t = (T) obj;
                System.out.println(t);
            }
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
                socket.close();
            } catch(Exception ex) {}
        }
    }
}
