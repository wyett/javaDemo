package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.MyLinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/30 20:01
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex02_DoublyLinkedList<E> {
    public static void
    exchangeAdjacentElement(MyLinkedList<E> le, int n) {
        if(le.size() < n + 1) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> p = le.get(n);
        Node<E> pnext = le.get(n + 1);

        p.next = pnext.next;
        p.prev.next = pnext;
        pnext.next = p;
        p.next.prev = p;
        p.prev = pnext;
        pnext.prev = p.prev;

        System.out.println(le.get(n) + ", " + le.get(n + 1));
    }

}
