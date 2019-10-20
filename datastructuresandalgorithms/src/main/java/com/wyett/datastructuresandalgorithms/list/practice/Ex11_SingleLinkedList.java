package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.Arrays;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/5 11:13
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex11_SingleLinkedList<E> {
    /**
     * class SNode
     */
    private class SNode<E> {
        public E data;
        //        public SNode<E> prev;
        public SNode<E> next;

        public SNode(E d, SNode<E> n) {
            this.data = d;
//            this.prev = p;
            this.next = n;
        }
    }

    // the header node, without tail node
    private SNode<E> beginMaker;

    public Ex11_SingleLinkedList() {
        doClear();
    }

    public void doClear() {
        clear();
    }

    public void clear() {
        beginMaker.next = null;
    }

//    public void init() {
//        beginMaker = new SNode<E>();
//        beginMaker.next = null;
//    }

    /**
     * @return the size of Linked list
     */
    public int size() {
        SNode<E> firstNode = beginMaker.next;
        int length = 0;
        if (firstNode.next != null) {
            length++;
            firstNode = firstNode.next;
        }
        return length;
    }

    /**
     * print data of list
     */
    public void printList() {
        E[] items = null;
        int i = 0;
        SNode<E> firstNode = beginMaker;
        while (firstNode.next != null) {
            items[i++] = firstNode.next.data;
            firstNode = firstNode.next;
        }
        System.out.println(Arrays.toString(items));
    }

    /**
     * check if list has node.data equals x
     *
     * @param x
     * @return
     */
    public boolean contains(E x) {
        SNode<E> pnode = beginMaker.next;
        while (pnode != null) {
            if (x.equals(pnode.data)) {
                return true;
            } else {
                pnode = pnode.next;
            }
        }
        return false;
    }

    public void add(E x) {
        SNode<E> pnode = new SNode<E>(x, beginMaker.next);
//        pnode.data = x;
//        pnode.next = beginMaker.next;
        beginMaker.next = pnode;
    }

    public boolean remove(E x) {
        if (!contains(x)) {
            return false;
        } else {
            SNode<E> pnode = beginMaker.next;
            SNode<E> pnext = pnode.next;
            while (!pnode.data.equals(x)) {
                pnode = pnext;
                pnext = pnext.next;
            }
        }
        return true;
    }
}
