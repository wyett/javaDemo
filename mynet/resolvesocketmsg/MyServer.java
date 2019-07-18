package mynet.resolvesocketmsg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 10:35
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);
        while(true) {
            Socket socket = server.accept();
            invoke(socket);
        }
    }

    private static void
    invoke(final Socket socket) throws IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new Runnable() {
//            @Override
//            public void run() {
//                ObjectInputStream is = null;
//                ObjectOutputStream os = null;
//                try {
//                    is = new ObjectInputStream(socket.getInputStream());
//                    os = new ObjectOutputStream(socket.getOutputStream());
//                    Object obj = is.readObject();
//                    User user = (User) obj;
//                    System.out.println("User: " + user.getName() +
//                            ", password: " + user.getPassword());
//                    user.setName(user.getName() + "_new");
//                    user.setPassword(user.getPassword() + "_new");
//                    os.writeObject(user);
//                    os.flush();
//                } catch(IOException | ClassNotFoundException ex) {
//                    ex.printStackTrace();
//                } finally {
//                    try {
//                        is.close();
//                        os.close();
//                        socket.close();
//                    } catch(Exception ex) {}
//                }
//            }
//        });
//        exec.shutdown();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectInputStream is = null;
                ObjectOutputStream os = null;
                try {
                    is = new ObjectInputStream(socket.getInputStream());
                    os = new ObjectOutputStream(socket.getOutputStream());
                    Object obj = is.readObject();
                    User user = (User)obj;
                    System.out.println("user: " + user.getName() + ", " +
                            "password" + user.getPassword());
                    user.setName(user.getName() + "_new");
                    user.setPassword(user.getPassword() + "_new");
                    os.writeObject(user);
                    os.flush();
                } catch(IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        is.close();
                        os.close();
                        socket.close();
                    } catch(Exception ex) {}
                }
            }
        }).start();
    }
}
