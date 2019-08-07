package datastructuresandalgorithms.list.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/7 17:02
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex20_LazyDeletion<E> {
    private class Node<E> {
        private E data;
        private byte delBit;

        public Node(E d) {
            this.data = d;
            this.delBit = (byte) 0;
        }
    }

    private List<Node<E>> items;
    private int normalNodeCount;
    private int delNodeCount;

    public Ex20_LazyDeletion() {
        this.items = new ArrayList<>();
        this.normalNodeCount = 0;
        this.delNodeCount = 0;
    }

    /**
     * add new Node<x, 0> into List
     * @param x
     */
    public void add(E x) {
        items.add(new Node<E>(x));
        normalNodeCount++;
    }

    /**
     * set node.delBit = 1, when node.data == x
     * @param x
     */
    public void remove(E x) {
        java.util.ListIterator<Node<E>> itemItr = items.listIterator();
        while(itemItr.hasNext()) {
            Node<E> item = itemItr.next();
            if(item.data.equals(x)) {
                item.delBit = (byte)1;
                itemItr.set(item);
                delNodeCount++;
            }
        }

        // remove from list;
        purge();
    }

    /**
     * drop all node wit delBit equals 1, when normalNodeCount
     * equals to delNodeCount;
     */
    public void purge() {
        if(normalNodeCount == delNodeCount &&
                normalNodeCount != 0) {
            int current = 0;
            int totalSize = items.size();
            while(delNodeCount-- > 0) {
                for(Node<E> tmpNode: items) {
                    if (tmpNode.delBit == 1) {
                        items.remove(tmpNode);
                    }
                }
            }
        }
    }
}
