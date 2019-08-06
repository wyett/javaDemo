package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.Iterator;
import datastructuresandalgorithms.list.example.MyLinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/6 16:04
 * @description: func splice
 */

public class Ex15_MyLinkedList<E> extends MyLinkedList<E> {
    public void splice(Iterator<E> itr, MyLinkedList<? extends E> lst) {
        java.util.Iterator<? extends E> lstIterator = lst.iterator();
        while(lstIterator.hasNext()) {
            E item = lstIterator.next();
            lstIterator.remove();
//            itr.next() = item;
//            super.addBefore(itr.next(), item);
        }
    }
}
