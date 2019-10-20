package com.wyett.datastructuresandalgorithms.bitmap;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/12 15:26
 * @description: interface bitmap
 */

public interface BitMap<E extends DataType> {
    /**
     * get slot index in array;
     *
     * @param pos
     * @return
     */
    int getSlotIndex(int pos);

    /**
     * get pos of element in slot;
     *
     * @param pos
     * @return
     */
    int getPosInSlot(int pos);

    /**
     * set bit to one at pos in array
     *
     * @param arr
     * @param pos
     */
    void setBitOne(E[] arr, int pos);

    /**
     * setbit to zero at pos in array
     *
     * @param arr
     * @param pos
     */
    void setBitZero(E[] arr, int pos);

    /**
     * add bit at last pos of arr
     *
     * @param arr
     */
    void add(E[] arr);

    /**
     * remove last bit of arr;
     *
     * @param arr
     */
    void remove(E[] arr);

    /**
     * build bitMap
     *
     * @return
     */
    E[] bitMapBuilder();
}
