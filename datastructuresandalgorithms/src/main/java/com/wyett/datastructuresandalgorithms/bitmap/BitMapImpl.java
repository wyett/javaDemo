package com.wyett.datastructuresandalgorithms.bitmap;

import java.util.Arrays;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/12 10:57
 * @description: bit map test by byte
 */

public class BitMapImpl<E extends DataType>
        implements BitMap<E> {
    // count of elements
    private int num;
    // the input array
    private Object[] items;
    // length of
//    private E[] bitArr;
    private int mark;
//    private int hexNum;

    /**
     * constructor
     *
     * @param num
     */
    public BitMapImpl(int num, Object[] items) {
        this.num = num;
        this.items = items;
//        this.mark = E.
    }

    /**
     * get pos of E
     *
     * @param pos
     * @return
     */
    @Override
    public int getSlotIndex(int pos) {
        return pos >> mark;
    }

    /**
     * get pos in E[i]
     *
     * @param pos
     * @return
     */
    @Override
    public int getPosInSlot(int pos) {
        return pos & 0x07;
    }

    /**
     * set bitArr[pos] as one
     *
     * @param pos
     * @return
     */
    @Override
    public void setBitOne(E[] bitArr, int pos) {
//        bitArr[getSlotIndex(pos)] |= 1 << getPosInSlot(pos);
    }

    /**
     * set bitArr[pos] as zero
     *
     * @param pos
     */
    @Override
    public void setBitZero(E[] bitArr, int pos) {
//        bitArr[getSlotIndex(pos)] &= ~(1 << getPosInSlot(pos));
    }

    /**
     * add element at the last pos of bitArr
     */
    @Override
    public void add(E[] bitArr) {
        setBitOne(bitArr, num);
    }

    /**
     * remove the last element in bitArr
     */
    @Override
    public void remove(E[] bitArr) {
        setBitZero(bitArr, num);
    }

    /**
     * builder
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] bitMapBuilder() {
        /** save element into bitArr, 8 per byte page.  if the xth
         element is not null, then set the xth bitpos of byte[] to
         be one. */
        E[] bitArr = (E[]) new Object[getSlotIndex(num) + 1];

        // if items[i] is not null ,then set bitArr[i] to be 1, else, 0
        for (int i = 0; i < num; i++) {
            if (items[i] != null) {
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
