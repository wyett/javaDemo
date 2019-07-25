package datastructuresandalgorithms.list.example;

import com.sun.org.apache.xpath.internal.functions.FuncTranslate;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/25 20:02
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyLinkedList<E> implements Iterable<E> {
    /** declare static class Node */
    private static class Node<E>{};

    // size of MyLinkedList
    private int theSize;
    // singal to mark change times
    private int modCount = 0;
    // external header node
    private Node<E> beginMaker;
    // external tail node
    private Node<E> endMarker;

    /**
     * constructor, build a null MyListedList
     */
    public MyLinkedListList() { doClear(); }

    /** declare func clear */
    public void clear() {}

    /**
     * get size of MyLinkedList
     * @return int
     */
    public int size() { return theSize; }

    /**
     * check if empty
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * add x at end of MyLinkedList
     * @param x
     * @return boolean
     */
    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    /**
     * add x at pos idx
     * @param idx
     * @param x
     * @return boolean
     */
    public boolean add(int idx, E x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    /**
     * get node.data at idx
     * @param idx
     * @return E
     */
    public E get(int idx) {
        return getNode(idx).data;
    }

    /**
     * replace Node.data at idx with newVal, and return oldVal
     * @param idx
     * @param newVal
     * @return E
     */
    public E set(int idx, E newVal) {
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    /**
     * remove node from MyLinkedList at idx
     * @param idx
     * @return E
     */
    public E remove(int idx) {
        return remove(getNode(idx));
    }

    /** declare func addBefore */
    private void addBefore(Node<E> p, E x) {}
    /** declare func remove */
    private E remove(Node<E> p) {}
    /** declare func getNode */
    private Node<E> getNode(int idx) {}
    /** declare func getNode with other version */
    private Node<E> getNode(int idx, int lower, int upper) {}

    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    /** inner class LinkedListIterator */
    private class LinkedListIterator implements java.util.Iterator<E> {}
}

private static class Node<E> {
    public Node(E d, Node<E> p, Node<E> n) {
        data = d;
        prev = p;
        next = n;
    }
    public E data;
    public Node<E> prev;
    public Node<E> next;
}



