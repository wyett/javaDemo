package datastructuresandalgorithms.tree.example.BTree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/21 18:01
 * @description: TODO
 */

public abstract class Page<E extends BTreeNode> {
    /** pageList is orgornized by linkedlist sorted by node.key */
    private LinkedList<E> pageList;
    /** the max of pageList */
    private int pageSize;

    public Page(LinkedList<E> pl, int ps) {
        this.pageSize = ps;
        this.pageList = new LinkedList<>();
    }

    /**
     * @return page size
     */
    public int size() {
        return pageList.size();
    }

    /**
     * get pos for insert node x
     * @param x
     * @return
     */
    public E getInsertPos(LinkedList<E> le, E x) {
        Iterator<E> leIter = le.iterator();
        E curCell = null;
        while(leIter.hasNext()) {
            curCell = leIter.next();
            if(x.key > curCell.key) {
                break;
            }
        }
        return curCell;
    }

    /**
     * insert x into linkedlist le orderly
     * @param le linkedlist
     * @param x element
     */
    private void insert(LinkedList<E> le, E x) {
        if(x.key > le.peekFirst().key
                && x.key < le.peekLast().key) {
            le.add(le.indexOf(getInsertPos(le, x)), x);
        }
    }

    /**
     * insert x into pageList
     * @param x
     */
    public void insert(E x) {
        insert(pageList, x);
    }

    /**
     * remove x from pageList, if size of pageList is less than half of pageSize
     * borrow element from the pre-page;
     * @param x
     */
    public void delete(E x) {
        if(pageList.size() == pageSize/2) {
            pageList.remove(x);
            borrow();
        } else if(pageList.size() > pageSize/2) {
            pageList.remove(x);
        }
    }

    /**
     * if pageList.size() equals to pageSize, split it into two part, insert
     * the first key of second part into parent List
     * @return the first element of the second part
     */
    public boolean split() {
        LinkedList<E> secondList = null;
        E SecondHead = null;
        if(pageList.size() == pageSize) {
            while(pageList.get(pageSize/2) != null) {
                secondList.add(pageList.remove(pageSize/2));
            }
        }
//        LinkedList<E> parentList = pageList.getFirst().parent;
        // to do
        // get parent list
        if(pageList.getFirst().parent != null) {
            pageList.getFirst().parent
        }
    }
    public void borrow() {}

    /**
     * if pare.node.delBit equals to 1, remove it from linked list
     */
    public void purgePage() {
        Iterator<E> pIter = pageList.iterator();
        E curCell = null
        while(pIter.hasNext()) {
            curCell = pIter.next();
            if(curCell.delBit == 1) {
                pageList.remove(curCell);
            }
        }
    }

//    perhaps func merge should be put in BTree
//    public LinkedList<E> merge() {}
}
