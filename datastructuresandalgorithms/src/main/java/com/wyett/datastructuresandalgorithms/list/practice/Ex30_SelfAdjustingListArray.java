package com.wyett.datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 21:17
 * @description: Self-adjusting list implements by array
 */

public class Ex30_SelfAdjustingListArray<E> {
    private Object[] items;
    private int theSize;

    public Ex30_SelfAdjustingListArray() {
        this.items = new Object[theSize];
    }

    public int get(E x) {
        int idx = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(x)) {
                idx = i;
                break;
            }
//            idx = items[i].equals(x) ? i : -1;
        }
        return idx;
    }

    public void find(E x) {
        int idx = get(x);
        for (int i = idx; i > 0; i--) {
            items[idx] = items[idx - 1];
        }
        items[0] = x;
    }
}
