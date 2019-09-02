package mynet.mynio;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/27 19:50
 * @description: TODO
 */

public class RegisterKeyDemo {
    public void checkRegister(SocketChannel channel) throws IOException{
        // create selector
        Selector selector = Selector.open();
        // set channel as non-blocking
        channel.configureBlocking(false);
        // register channel on selector
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
        // jobs of selector
        while(true) {
            int readChannels = selector.select();
            if(readChannels == 0) {
                continue;
            }
            // get selector keys
            Set selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            // get channel's status
            while(keyIterator.hasNext()) {
                key = keyIterator.next();
                if(key.isAcceptable()) {

                } else if (key.isConnectable()) {

                } else if (key.isReadable()) {

                } else if (key.isWritable()) {

                }
                keyIterator.remove();
            }
        }
    }
}
