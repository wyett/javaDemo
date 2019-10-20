package com.wyett.thinkinjava.concurrency;
import java.net.*;
import java.util.concurrent.*;
import java.io.*;
import static com.wyett.util.Print.*;

/**
 * @author : chelei
 * @date : Created in 2019/7/4 16:01
 * @description: TODO
 * @modified By:
 * @version: $
 */


public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput =
                new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        print("Shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        print("Closing " + socketInput.getClass().getName());
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        print("Closing " + System.in.getClass().getName());
        System.in.close();
    }
}
