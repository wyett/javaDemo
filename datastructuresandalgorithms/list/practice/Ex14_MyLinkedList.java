package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.MyLinkedList;

import java.util.ConcurrentModificationException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/6 12:19
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex14_MyLinkedList<E>
        extends MyLinkedList<E> implements Iterable<E>{

    private class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(E d, Node<E> p, Node<E> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }
    }

    // header beginMaker
    private Node<E> beginMaker;
    // tail endMaker
    private Node<E> endMaker;
    // count of list has been modified
    private int modCount;
//    private boolean okToRemove;

    public Ex14_MyLinkedList(Node<E> beginMaker,
                             Node<E> endMaker,
                             int modCount) {
        super();
        this.beginMaker = beginMaker;
        this.endMaker = endMaker;
        this.modCount = modCount;
    }

    /** some other func */

    public java.util.ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator
            implements java.util.ListIterator<E> {
        private Node<E> current = beginMaker.next;
        private int expectedModCount = modCount;

        @Override
        public boolean hasPrevious() {
            return current.prev != beginMaker;
        }

        @Override
        public boolean hasNext() {
            return current.next != endMaker;
        }

        @Override
        public E next() {
            if(modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            E elementData = current.data;
            current = current.next;
            return elementData;
        }

        @Override
        public E previous() {
            if(modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasPrevious()) {
                throw new java.util.NoSuchElementException();
            }

            E elementData = current.data;
            current = current.prev;
            return elementData;
        }

        @Override
        public void set(E x) {
//            if(modCount != expectedModCount) {
//                throw new ConcurrentModificationException();
//            }
//
//            Ex14_MyLinkedList.super.set(current.next, x);
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public void add(E x) {
            if(modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            Ex14_MyLinkedList.super.add(x);
        }

        @Override
        public void remove() {
//            if(modCount != expectedModCount) {
//                throw new java.util.ConcurrentModificationException();
//            }
//
//            Ex14_MyLinkedList.super.remove(current.prev);
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
