package datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/9 14:53
 * @description: single linked list without start and tail node
 */

public class SinglyListWithnotEnd<E> {
    private class Node<E> {
        E data;
        Node<E> next;

        Node(E d, Node<E> n) {
            this.data = d;
            this.next = n;
        }

        Node(E d) {
            this.data = d;
            this.next = null;
        }

        Node() {
            this.data = null;
            this.next = null;
        }
    }

    // size
    private int theSize;
    // node
    private Node<E> frontNode;

    /**
     * constructor
     */
    public SinglyListWithnotEnd() {
        frontNode = null;
        theSize = 0;
    }

    /**
     * first node
     */
    private void init() {
        frontNode = new Node<>();
        theSize = 1;
    }

    /**
     * check if empty
     */
    public boolean isEmpty() {
        return theSize == 0;
    }

    /**
     * @return size
     */
    public int size() {
        return theSize;
    }

    /**
     * check if pos is proper
     * @param idx pos
     */
    private void checkPosition(int idx) {
        if(idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * get node at idx pos
     * @param idx
     * @return
     */
    private Node<E> getNode(int idx) {
        checkPosition(idx);

        Node<E> curNode = frontNode;
        int currentPos = 0;
        while(currentPos++ < idx) {
            curNode = curNode.next;
        }

        return curNode;
    }

    /**
     * add node with data x after node prev
     * @param prev
     * @param x
     */
    private void addAfter(Node<E> prev, E x) {
        Node<E> curNode = new Node<>(x);
        if(prev.next == null) {
            prev.next = curNode;
        } else {
            curNode.next = prev.next;
            prev.next = curNode;
        }
        theSize++;
    }

    /**
     * add node with data x at pos idx, when idx equals zero, call init()
     * when idx is bigger than zero, call addAfter(prev, x)
     * @param idx pos
     * @param x
     */
    public void add(int idx, E x) {
        checkPosition(idx);

        if(idx == 0) {
            init();
            frontNode.data = x;
        } else {
//            System.out.println(idx + ": " + getNode(idx - 1).data);
//            System.out.println(idx);
            addAfter(getNode(idx - 1), x);
        }
    }

    /**
     * add node with x at the tail of list
     * @param x
     */
    public void add(E x) {
        add(theSize, x);
    }

    /**
     * remove node at pos;
     * @param idx
     * @return
     */
    public E remove(int idx) {
        checkPosition(idx);

        Node<E> curNode = getNode(idx);
        if(idx == 0) {
            curNode.next = null;
            theSize--;
        } else {
            Node<E> prevNode = getNode(idx - 1);
            prevNode.next = curNode.next;
            curNode.next = null;
            theSize--;
        }
        return curNode.data;
    }

    /**
     * remove node at the tail pos
     * @return
     */
    public E removeLast() {
        return remove(theSize-1);
    }

    /**
     * get value of node at pos idx
     * @param idx
     * @return
     */
    public E get(int idx) {
        checkPosition(idx);
        return getNode(idx).data;
    }

    /**
     * get value of last node
     * @return
     */
    public E getLast() {
        return get(theSize - 1);
    }
}
