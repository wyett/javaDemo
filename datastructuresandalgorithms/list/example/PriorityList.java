package datastructuresandalgorithms.list.example;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/1 18:48
 * @description: TODO
 */

public class PriorityList<E> {
    private class PriorityNode<E> {
        public E item;
        public int priorityValue;

        public PriorityNode(E type, int value) {
            item = type;
            priorityValue = value;
        }
    }

    private List<PriorityNode<E>> pne =
            new ArrayList<PriorityNode<E>>();
    public PriorityList() { }

    public boolean contains(E type) {
        if(pne == null) {
            throw new NullPointerException();
        }
        E tmpElem = null;
        for(PriorityNode<E> n : pne) {
            if(n.item == type) {
                tmpElem = type;
                break;
            }
        }

        if(tmpElem == null) {
            return false;
        }
        return true;
    }
    /**
     * add element into List
     * @param type
     * @param val
     */
    public void add(E type, int val) {
        PriorityNode<E> pe = new PriorityNode<>(type, val);
        pne.add(pe);
    }

    /**
     * get priority value of item
     * @param type
     * @return
     */
    public int getPriorityValue(E type) {
        int value = 0;

        if(pne == null || pne.contains(type)) {
            throw new NoSuchElementException();
        }

        for(PriorityNode<E> pnode: pne) {
            if(pnode.item == type) {
                value = pnode.priorityValue;
            }
        }
        return value;
    }
}
