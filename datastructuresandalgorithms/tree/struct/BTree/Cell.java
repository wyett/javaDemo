package datastructuresandalgorithms.tree.struct.BTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/20 19:15
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Cell<E extends Item> {
    public Item data;
    public byte delBit;

    Cell(E d, byte b){
        this.data = d;
        this.delBit = b;
    }

    public void setDelBit() {
        this.delBit = (byte)1;
    }

    public byte getDelBit() {
        return this.delBit;
    }
}
