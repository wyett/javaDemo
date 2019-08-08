package datastructuresandalgorithms.list.practice;

import java.util.LinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 20:36
 * @description: reverse linkedlist with space complexity O(1) cost
 */

public class Ex29_ReversedLinkedList<E> {
    private class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node() { }

        public Node(E d, Node<E> p, Node<E> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }
    }
    private Node<E> beginMaker;
    private Node<E> endMaker;
    private LinkedList<E> tmpLinkedList = new LinkedList<>();

    public Ex29_ReversedLinkedList() {}

    /**
     * current.next change to current.prev
     * current.prev change to current.next
     * pcn become npc, then, remove n and return n
     * and header.next point to current;
     */
    public void reversedLinkedList() {
        Node<E> currentPos, nextPos, previousPos;

        previousPos = null;
        currentPos = beginMaker.next;
        nextPos = currentPos.next;

        while(nextPos != null) {
            currentPos.next = previousPos;
            previousPos = currentPos;
            currentPos = nextPos;
            nextPos = nextPos.next;
        }

        currentPos.next = previousPos;

        beginMaker.next = currentPos;
    }
}
