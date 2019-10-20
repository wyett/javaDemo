package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/7 11:16
 * @description: LinkedList without header and tailer node
 */

public class Ex19_MyLinkedListWithOutHeadAndTail<E>
        implements Iterable<E> {
    private class Node<E> {
        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(E d, Node<E> p, Node<E> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }

        public Node(E d, Node<E> p) {
            this.data = d;
            this.prev = p;
        }
    }

    private Node<E> node;
    private int modCount;
    private int theSize;

    public Ex19_MyLinkedListWithOutHeadAndTail() {
        doClear();
    }

    public void doClear() {
        clear();
    }

    public void clear() {
        this.node = null;
        this.modCount = 0;
        this.theSize = 0;
    }

    /**
     * @return check has element
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return theSize
     */
    public int size() {
        return theSize;
    }

    /**
     * get positive node according to id
     *
     * @param idx the idx node
     * @return node
     */
    public Node<E> getNode(int idx) {
        if (idx < 0 || size() < idx || size() == 0) {
            throw new NoSuchElementException();
        }

        Node<E> p = node;
        int currentPos = 0;

        while (currentPos <= idx) {
            p = p.next;
            currentPos++;
        }
        return p;
    }

    public E get(int idx) {
        return getNode(idx).data;
    }

    public void addBefore(Node<E> p, E x) {
        if (isEmpty()) {
            Node<E> curnode = new Node<E>(x, null, null);
        } else {
            Node<E> curnode = new Node<E>(x, null, null);
            curnode.prev = p.prev;
            curnode.next = p;
            p.prev.next = curnode;
            p.prev = curnode;
            theSize++;
            modCount++;
        }
    }

    public void add(int idx, E x) {
        addBefore(getNode(idx), x);
    }

    public void add(E x) {
        addBefore(getNode(size()), x);
    }

    public void remove(Node<E> current) {
        if (current == getNode(size())) {
            current.prev.next = null;
            current.prev = null;
            theSize--;
            modCount++;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
            theSize--;
            modCount++;
        }
    }

    /**
     * remove the idx node, specify idx equals size() or not
     *
     * @param idx
     * @return current.data
     */
    public void remove(int idx) {
        if (idx < 0 || idx > size()) {
            throw new NoSuchElementException();
        }
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        remove(getNode(idx));
    }


    public void removeAll() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        while (theSize > 0) {
            remove(0);
        }
    }

    public void set(int idx, E x) {
        if (idx < 0 || idx > size()) {
            throw new NoSuchElementException();
        }

        Node<E> current = getNode(idx);
        current.data = x;
    }

    public boolean contains(E x) {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Node<E> current = getNode(0);

        while (current.data.equals(x)) {
            current = current.next;
        }

        return current != getNode(size());
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current;
        private int expectModCount = modCount;

        @Override
        public boolean hasNext() {
            Node<E> endNode
                    = Ex19_MyLinkedListWithOutHeadAndTail.this.getNode(size());
            return current != endNode;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E currentData = current.data;
            current = current.next;
            return currentData;
        }

        @Override
        public void remove() {
            Ex19_MyLinkedListWithOutHeadAndTail.this.remove(current.next);
        }
    }
}












