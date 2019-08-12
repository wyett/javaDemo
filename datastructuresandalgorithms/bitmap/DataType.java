package datastructuresandalgorithms.bitmap;

import javax.xml.crypto.Data;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/12 15:45
 * @description: TODO
 */

//public enum DataType {
//    BYTE("byte"), LONG("long"), INT("int");
//    String type;
//    DataType(String type) {
//        this.type = type;
//    }
//    public String getType() {
//        return type;
//    }
//    public int getLen() {
//        return type.length();
//    }
//
//}

public enum DataType {
    // byte
    BYTE("byte", 3, 0x07),
    // long
    LONG("long", 6, 0x3E);
    String type;
    int length, hexNum;

    /**
     * constructor
     * @param type
     * @param len
     */
    DataType(String type, int len, int hexNum) {
        this.type = type;
        this.length = len;
        this.hexNum = hexNum;
    }

    /**
     * get java.lang.Number
     */
    public String getType() {
        return type;
    }

    /**
     * get length of datatype
     * @return
     */
    public int getLen() {
        return length;
    }

    public int getHexNum(){
        return hexNum;
    }
}
