package datastructuresandalgorithms.bitmap;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/12 14:44
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class BitOperationDemo {
    public static void main(String[] args) {
        System.out.println("100 >> 3 : " + (100 >> 3));
        System.out.println("100 & 0x07 : " + (100 & 0x07));
        System.out.println("1 << 100 & 0x07 : " + (byte)(1 << 100 & 0x07));
//        System.out.println("(100 >> 3) |= 1 << 100 & 0x07 : " +
//                ((100 >> 3) |= (1 << (100 & 0x07)));
        System.out.println("100 & 0x64 :" + (100 & 0x3E));
    }
}
