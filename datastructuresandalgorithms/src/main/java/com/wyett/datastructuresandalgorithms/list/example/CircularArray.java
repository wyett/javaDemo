package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/2 17:07
 * @description:
 */

public class CircularArray<E> {
    private E[] arrItem;
    private int arrSize;
    private int currencyPos;

    public CircularArray(int arrSize) {
        this.arrSize = arrSize;
    }

    public void add(E elem) {
        if (size() < arrSize) {
            currencyPos = size() + 1;
            arrItem[currencyPos] = elem;
        } else {
            arrItem[++currencyPos % size()] = elem;
        }
    }

    public E remove() {
        E[] newItem = arrItem;
        arrItem = null;
        if (newItem.length > 0) {
            for (int i = 1; i < size(); i++) {
                arrItem[i - 1] = newItem[i];
            }
        }
        return newItem[0];
    }

    public int size() {
        return arrItem.length;
    }
}
