package mynet.concurrencysocket;

import mynet.concurrencysocket.datamodel.UserInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 21:19
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ClientPointSocket implements Runnable{
//    private Socket socket = null;
//    public ClientPointSocket(Socket socket) {
//        this.socket = socket;
//    }
    private String userName;
    private String userPassword;
    private String host;
    private int port;
    public ClientPointSocket(String userStr) {
        this.userName = userStr.split(" ")[0];
        this.userPassword = userStr.split(" ")[1];
        ReadProperties rp = new ReadProperties("master.properties");
        this.host = rp.getItemValue("master_ip");
        this.port = Integer.parseInt(rp.getItemValue("master_port"));
    }
    public void run() {
        Socket socket = null;
        ObjectInputStream is = null;
        ObjectOutputStream os = null;
        try {
            socket = new Socket(host, port);
            os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(new UserInfo(userName, userPassword));
            os.flush();

            // input
            is = new ObjectInputStream(socket.getInputStream());
            Object obj = is.readObject();
            if(obj != null) {
                UserInfo userInfo = (UserInfo) obj;
                System.out.println("user: " + userInfo.getName() +
                        ", password: " + userInfo.getPassword());
            }
        } catch(IOException | ClassNotFoundException ex) {
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
