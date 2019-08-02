package datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/2 17:15
 * @description: TODO
 */

public class MyArrayQueue<E> {
    private E[] arrItem;
    private int arrSize;
    public MyArrayQueue(int arrSize) {
        this.arrSize = arrSize;
    }

    public void add(E elem) {
        if(size() < arrSize) {
            arrItem[size() + 1] = elem;
        }
    }

    public E remove() {
        E[] newItem = arrItem;
        arrItem = null;
        if(newItem.length > 0) {
            for(int i=1; i< size(); i++) {
                arrItem[i-1] = newItem[i];
            }
        }
        return newItem[0];
    }

    public int size() {
        return arrItem.length;
    }
}
