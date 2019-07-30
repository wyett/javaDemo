package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.MyLinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/30 20:52
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex03_MyLinkedListContains<E> {
    MyLinkedList<E> me = new MyLinkedList<>();
//    public Ex03_MyLinkedListContains(int theSize, int modCount,
//                                     Node<E> beginMaker,
//                                     Node<E> endMaker) {
//        super(theSize, modCount, beginMaker, endMaker);
//    }
    public boolean contains(E ed) {
        Node<E> p = beginMaker.next;
        while(p != endMaker && !(p.data.equals(ed))) {
            p = p.next;
        }
        return (p != endMaker);
    }
}
