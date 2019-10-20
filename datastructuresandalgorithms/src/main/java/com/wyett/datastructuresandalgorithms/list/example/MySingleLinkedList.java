package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/9 10:38
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MySingleLinkedList<E> {
    /**
     * node
     */
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

    /**
     * init
     */
    public MySingleLinkedList() {
        doClear();
    }

    /**
     * do clear
     */
    public void doClear() {
        clear();
    }

    /**
     * clear
     */
    public void clear() {
        header.next = tailer;
        tailer.next = null;
        theSize = 0;
    }

    /**
     * check if list is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return theSize == 0;
    }

    /**
     * @return size of list
     */
    public int size() {
        return theSize;
    }

    /**
     * add x into list at the tail
     *
     * @param x
     */
    public void add(E x) {
        addAfter(getNode(size() - 1), x);
    }

    /**
     * add x into list at idx pos
     *
     * @param idx
     * @param x   node.data
     */
    public void add(int idx, E x) {
        addAfter(getNode(idx), x);
    }

    /**
     * add node with x after node n
     *
     * @param n node
     * @param x newnode.data
     */
    public void addAfter(Node<E> n, E x) {
        Node<E> newNode = new Node<E>(x, null);
        newNode.next = n.next;
        n.next = newNode;
        theSize++;
    }

    /**
     * add collection into list at the tail
     *
     * @param c
     * @return
     */
    public boolean addAll(java.util.Collection<? extends E> c) {
        return addAll(theSize, c);
    }

    /**
     * insert collection into list at pos idx
     *
     * @param idx
     * @param c
     * @return
     */
    public boolean addAll(int idx, java.util.Collection<? extends E> c) {
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] cc = c.toArray();
        if (cc.length == 0) {
            return false;
        }

        for (Object o : cc) {
            add(idx, (E) o);
        }

        return true;
    }

    /**
     * get the idx element
     *
     * @param idx
     * @return Node
     */
    public Node<E> getNode(int idx) {
        checkPositionIndex(idx);

        Node<E> tmpNode = null;
        int currentPos = -1;
        while (currentPos++ < idx) {
            tmpNode = tmpNode.next;
        }

        return tmpNode;
    }

    /**
     * remove the idx element
     *
     * @param idx
     * @return node.data
     */
    public E remove(int idx) {
        checkPositionIndex(idx);

        E tmpData = null;
        if (idx == 0) {
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

    /**
     * remove the tail element
     *
     * @return
     */
    public E removeLast() {
        return remove(theSize);
    }

    /**
     * check if pos idx is proper
     *
     * @param idx
     */
    public void checkPositionIndex(int idx) {
        if (idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
    }
}













