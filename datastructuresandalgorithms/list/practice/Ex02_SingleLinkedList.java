package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.MyLinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/30 19:11
 * @description: single List
 */

public class Ex02_SingleLinkedList<E> {
    /**
     * swap element n and n+1
     * @param le LinkedList le, with private class
     *           Node<E>( E data, Node<E> next)
     * @param n the nth element of le
     */
    public static void
    exchangeAdjacentElement(MyLinkedList<E> le, int n) {
        if(le.size() < n + 1)  {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = le.get(n);
        Node<E> pnext = le.get(n + 1);
        Node<E> pprev = le.get(n - 1);

        p.next = pnext.next;
        pprev.next = pnext;
        pnext.next = p;

        System.out.println(le.get(n) + ", " + le.get(n + 1));
    }
}
