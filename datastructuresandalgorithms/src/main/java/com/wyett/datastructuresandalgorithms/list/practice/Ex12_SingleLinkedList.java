package com.wyett.datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/5 17:36
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex12_SingleLinkedList<E extends Comparable<? super E>> {
    private class Node<E> {
        public E data;
        public Node<E> next;

        public Node(Node<E> n) {
            this.next = n;
        }

        public Node(E d, Node<E> n) {
            this.data = d;
            this.next = n;
        }
    }

    // header node
    private Node<E> beginMaker;
    // size
    private int theSize = 0;

    // init
    public Ex12_SingleLinkedList() {
        beginMaker = new Node<E>(null);
        beginMaker.next = null;
    }

    /**
     * check if list contains x
     *
     * @param x
     * @return
     */
    public boolean contains(E x) {
        Node<E> pnext = beginMaker.next;
        while (pnext != null) {
            if (pnext.data.equals(x)) {
                return true;
            } else {
                pnext = pnext.next;
            }
        }
        return false;
    }

    /**
     * add x into list as sorted list
     *
     * @param x
     */
    public void add(E x) {
        Node<E> pnext = beginMaker.next;
        Node<E> xnode = new Node<E>(x, null);
        while (pnext != null) {
            if (pnext.data.compareTo(xnode.data) < 0 &&
                    pnext.next.data.compareTo(xnode.data) >= 0) {
                xnode.next = pnext.next;
                pnext.next = xnode;
                theSize++;
            } else {
                pnext = pnext.next;
            }
        }
    }

    /**
     * remove x from list
     *
     * @param x
     * @return
     */
    public boolean remove(E x) {
        Node<E> pnext = beginMaker.next;
        if (!contains(x)) {
            return false;
        } else {
            while (pnext != null) {
                if (pnext.data.equals(x)) {
                    pnext = pnext.next;
                    pnext.next = pnext.next.next;
                    theSize--;
                }
            }
        }
        return true;
    }

    /**
     * get size of list
     *
     * @return
     */
    public int size() {
        return theSize;
    }
}
