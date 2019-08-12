package datastructuresandalgorithms.bitmap;

import java.util.Arrays;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/12 20:26
 * @description: TODO
 */

public class BitMapByteImpl {
    private int num;
    private Object[] items;
    private final static int mark = 3;

    public BitMapByteImpl(int num, Object[] items) {
        this.num = num;
        this.items = items;
    }
    /**
     * get pos of byte[]
     * @param pos
     * @return
     */
    public int getSlotIndex(int pos) {
        return pos >> mark;
    }

    /**
     * get pos in byte[i]
     * @param pos
     * @return
     */
    public int getPosInSlot(int pos) {
        return pos & 0x07;
    }

    /**
     * set bitArr[pos] as one
     * @param pos
     * @return
     */
    public void setBitOne(byte[] bitArr, int pos) {
        bitArr[getSlotIndex(pos)] |= 1 << getPosInSlot(pos);
    }

    /**
     * set bitArr[pos] as zero
     * @param bitArr
     * @param pos
     */
    public void setBitZero(byte[] bitArr, int pos) {
        bitArr[getSlotIndex(pos)] &= ~(1 << getPosInSlot(pos));
    }

    /**
     * set the last pos in lasty byte to one
     * @param bitArr
     */
    public void add(byte[] bitArr) {
        setBitOne(bitArr, num);
    }

    /**
     * remove the last pos in lasty byte to zero
     * @param bitArr
     */
    public void remove(byte[] bitArr) {
        setBitZero(bitArr, num);
    }

    /**
     * bit Map builder
     * @return byte[]
     */
    public byte[] bitMapBuilder() {
        /** save element into bitArr, 8 per byte page.  if the xth
         element is not null, then set the xth bitpos of byte[] to
         be one. */
        byte[] bitArr= new byte[getSlotIndex(num) + 1];

        // if items[i] is not null ,then set bitArr[i] to be 1, else, 0
        for(int i = 0; i < num; i++) {
            if(items[i] != null) {
                setBitOne(bitArr, i);
            } else {
                setBitZero(bitArr, i);
            }
        }
        return bitArr;
    }

    @Override
    public String toString() {
        return Arrays.toString(bitMapBuilder());
    }
}
