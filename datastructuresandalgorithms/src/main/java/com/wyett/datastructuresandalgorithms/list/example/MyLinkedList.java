package com.wyett.datastructuresandalgorithms.list.example;

import java.util.Iterator;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/25 20:02
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyLinkedList<E> implements Iterable<E> {
    /**
     * inner class Node<E>
     */
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
    public MyLinkedList() {
        doClear();
    }


    /**
     * clear MyLinkedList
     */
    public void clear() {
        doClear();
    }

    /**
     * clear MyLinkedList
     */
    public void doClear() {
        beginMaker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMaker, null);
        beginMaker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    /**
     * get size of MyLinkedList
     *
     * @return int
     */
    public int size() {
        return theSize;
    }

    /**
     * check if empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * add x at end of MyLinkedList
     *
     * @param x
     * @return boolean
     */
    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    /**
     * add x at pos idx
     *
     * @param idx
     * @param x
     * @return boolean
     */
    public void add(int idx, E x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    /**
     * get node.data at idx
     *
     * @param idx
     * @return E
     */
    public E get(int idx) {
        return getNode(idx).data;
    }

    /**
     * replace Node.data at idx with newVal, and return oldVal
     *
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
     *
     * @param idx
     * @return E
     */
    public E remove(int idx) {
        return remove(getNode(idx));
    }

    public void removeAll(Iterable<? extends E> items) {
        Iterator<? extends E> itemIterator = items.iterator();
        E item, element;
        while (itemIterator.hasNext()) {
            item = itemIterator.next();

            Iterator<E> theIter = iterator();
            while (theIter.hasNext()) {
                element = theIter.next();
                if (element.equals(item)) {
                    theIter.remove();
                }
            }
        }
    }

    /**
     * check if LinkedList contains x
     *
     * @param x element to be checked
     * @return check result
     */
    public boolean contains(E x) {
        Node<E> p = beginMaker.next;
        while (p != endMarker && !(p.data.equals(x))) {
            p = p.next;
        }
        return (p.next != endMarker);
    }

    /**
     * Adds an item to this collection, at specified pos p.
     * Items at or after that position are slid one position higher.
     *
     * @param p Node to add before
     * @param x E type object
     * @throws IndexOutOfBoundsException if idx is not between 0 and size
     */
    public void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * Removes the object contained in Node p
     *
     * @param p the Node containing the object and to be removed
     * @return the item was removed from the collection
     */
    private E remove(Node<E> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    /**
     * Gets the Node at position idx, which must range from 0
     * to size() - 1,
     *
     * @param idx index to search at
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not
     *                                   between 0 and size() - 1
     */
    private Node<E> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the Node at position idx, which must range from
     * lower to upper.
     *
     * @param idx   index to search at.
     * @param lower lowest valid index.
     * @param upper upper highest valid index
     * @return internal node correspond to idx
     * @throws IndexOutOfBoundsException if idx is not
     *                                   between lower and upper,inclusive
     */
    private Node<E> getNode(int idx, int lower, int upper) {
        Node<E> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < size() / 2) {
            p = beginMaker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * inner class LinkedListIterator
     */
    private class LinkedListIterator implements java.util.Iterator<E> {

        private Node<E> current = beginMaker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        /**
         * @return check if has next element
         */
        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        /**
         * @return return if has next element
         */
        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        /**
         * remove current element
         */
        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }
}



