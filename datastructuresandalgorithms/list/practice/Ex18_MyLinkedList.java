package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.Iterator;
import thinkinjava.concurrency_ex.Ex18;

import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/6 19:30
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex18_MyLinkedList<E> implements Iterable<E> {
    private class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E d, Node<E> p, Node<E> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }
    }

    private Node<E> beginMaker;
    private Node<E> endMaker;
    private int modCount = 0;
    private int theSize = 0;

    public Ex18_MyLinkedList() {
        doClear();
    }

    public void doClear() {
        clear();
    }

    public void clear() {
        beginMaker.next = null;
        endMaker.prev = null;
        modCount = 0;
        theSize = 0;
    }

    public boolean isEmpty() {
        return endMaker.prev == null;
    }

    public int size() {
        return theSize;
    }

    public void add(E x) {
//        Node<E> newNode = new Node<E>(x, null, null);
//        newNode.prev.next = newNode;
//        newNode.next = endMaker;
        add(size(), x);
    }

    public void add(int idx, E x) {
        addBefore(getNode(idx, 0, size()-1), x);
    }

    public void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<E>(x, null, null);
        newNode.prev = p.prev;
        newNode.next = p;
        p.prev.next = newNode;
        p.prev = newNode;
        modCount++;
        theSize++;
    }

    public void remove(Node<E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        theSize--;
        modCount++;
    }

    public void remove(int idx) {
        remove(getNode(idx));
    }

    public void removeAll() {
        while(beginMaker.next != endMaker) {
            remove(0);
        }
    }

    public boolean contains(E x) {
        Node<E> p = beginMaker.next;

        if(p != endMaker && !(p.data.equals(x))) {
            p = p.next;
        }

        return (p.next != endMaker);

    }

    public E get(int idx) {
        return getNode(idx).data;
    }

    public Node<E> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * get Node at pos idx, and range from start to end
     * @param idx
     * @param start
     * @param end
     * @return
     */
    public Node<E> getNode(int idx, int start, int end) {
        Node<E> p;
        if(start < 0 || end > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        if(idx < size()/2) {
            p = beginMaker.next;
            for(int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMaker.prev;
            for(int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public E set(int idx, E newVal) {
        Node<E> n = getNode(idx);
        E oldVal = n.data;
        n.data = newVal;
        return oldVal;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current = beginMaker.next;
//        private Node<E>
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return current.next != endMaker;
        }

        /**
         * @return current.data
         */
        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return current.data;
        }

        @Override
        public void remove() {
            Ex18_MyLinkedList.this.remove(current);
            expectedModCount++;
        }
    }

    public java.util.ListIterator<E> listIterator() {
        return new LinkedListListIterator();
    }

    private class LinkedListListIterator implements java.util.ListIterator<E>{
        private Node<E> current = beginMaker.next;
        private int exceptedModCount = modCount;

        @Override public boolean hasNext() {
            return current != endMaker;
        }
        @Override public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.data;
            current = current.next;
            return item;
        }
        @Override public boolean hasPrevious() {
            return current != beginMaker;
        }
        @Override public E previous() {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            E item = current.prev.data;
            current = current.prev;
            return item;
        }
        @Override public void remove() {
            Ex18_MyLinkedList.this.remove(current.prev);
            exceptedModCount++;
        }

        @Override public int nextIndex() {
            throw new java.lang.UnsupportedOperationException();
        }
        @Override public int previousIndex() {
            throw new java.lang.UnsupportedOperationException();
        }
        @Override public void set(E x) {
            Node<E> n = current;
            E oldVal = current.data;
            current.data = x;
//            return oldVal;
        }
        @Override public void add(E x) {
            Ex18_MyLinkedList.this.add(x);
            exceptedModCount++;
        }
    }

    public void addFirst(E x) {
        add(0, x);
    }

    public void addLast(E x) {
        add(size(), x);
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size());
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size());
    }
}

