package mynet.concurrencysocket;

import java.io.*;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/17 15:20
 * @description: Read properties file
 * @modified By:
 * @version: $
 */

public class ReadProperties {
    private String filename;

    public ReadProperties(String filename) {
        this.filename = filename;
    }
    public String getItemValue(String item) {
        Properties properties = new Properties();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(filename));
            properties.load(bufferedReader);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(item);
    }
}
