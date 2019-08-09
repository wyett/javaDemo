package datastructuresandalgorithms.list.example;

import java.util.EmptyStackException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/9 10:38
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MySingleLinkedList<E> {
    /** node */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E d, Node<E> n) {
            this.data = d;
            this.next = n;
        }


    }

    // begin node
    private Node<E> header;
    // tail node
    private Node<E> tailer;
    // size
    private int theSize;

    public MySingleLinkedList() {
        doClear();
    }

    public void doClear() {
        clear();
    }
    public void clear() {
        header.next = tailer;
        tailer.next = null;
        theSize = 0;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public int size() {
        return theSize;
    }

    public void add(E x) {
        addAfter(getNode(size() - 1), x);
    }

    public void add(int idx, E x) {
        addAfter(getNode(idx), x);
    }

    public void addAfter(Node<E> n, E x) {
        Node<E> newNode = new Node<E>(x, null);
        newNode.next = n.next;
        n.next = newNode;
        theSize++;
    }

    public boolean addAll(java.util.Collection<? extends E> c) {
        return addAll(theSize, c);
    }

    public boolean addAll(int idx, java.util.Collection<? extends E> c) {
        if(idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] cc = c.toArray();
        if(cc.length == 0) {
            return false;
        }

        for(Object o: cc) {
            add(idx, (E)o);
        }

        return true;
    }

    public Node<E> getNode(int idx) {
        checkPositionIndex(idx);

        Node<E> tmpNode = null;
        int currentPos = -1;
        while(currentPos++ < idx) {
            tmpNode = tmpNode.next;
        }

        return tmpNode;
    }

    public E remove(int idx) {
        checkPositionIndex(idx);

        E tmpData = null;
        if(idx == 0) {
            Node<E> currentNode = header.next;
            tmpData = currentNode.data;
            header.next = currentNode.next;
            currentNode.next = null;
            theSize--;
        } else {
            Node<E> prevNode = getNode(idx - 1);
            Node<E> currentNode = getNode(idx);
            tmpData = currentNode.data;
            prevNode.next = currentNode.next;
            currentNode.next = null;
            theSize--;
        }

        return tmpData;
    }

    public void checkPositionIndex(int idx) {
        if(idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
    }
}













