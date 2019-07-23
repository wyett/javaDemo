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
//        String fpath = getFilePath();
//        this.filename = fpath + filename;
//        System.out.println("fpath = " + fpath +
//            "filename = " + filename);
        this.filename = filename;
    }
//    public String getFilePath() {
//        return Class.class.getClass().getResource("/").getPath();
//        return Class.class.getClassLoader()
//                .getResource("/").getPath();
//    }
    public String getItemValue(String item) {
        Properties properties = new Properties();
        try {
            InputStream inputStream =
                    new BufferedInputStream(
                            new FileInputStream(filename));
            properties.load(inputStream);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(item);
    }
}
