package thinkinjava.concurrency_ex.ovals;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 17:32
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Item {
    private static int count;
    private int id = count++;
    public String toString() { return "Item " + id; }
}
