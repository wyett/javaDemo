package mynet.test;

import mynet.concurrencysocket.ReadProperties;
import org.junit.jupiter.api.Test;

import static com.wyett.util.Print.print;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/18 15:18
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ReadPropertiesTest {
    @Test
    public static void main(String[] args) {
        ReadProperties rp = new ReadProperties(
                "../concurrencysocket/master.properites");
        print(rp.getItemValue("master_ip"));
    }
}
