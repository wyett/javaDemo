package com.wyett.datastructuresandalgorithms.tree.example.BTree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/21 18:01
 * @description: page struct
 */

public class Page<E extends BTreeNode<? extends Cell>> {
    /**
     * pageList is orgornized by linkedlist sorted by node.key
     */
    private LinkedList<E> pageList;
    /**
     * the max of pageList
     */
    private int pageMaxSize;
    /**
     * count of node.delBit equals to 0
     */
    private int pageSize;
    /**
     * (size() - realSize()) / pageMaxSize
     */
    private final static int HIGH_WATER = 30;

    public Page(int pms) {
        this.pageMaxSize = pms;
        this.pageList = new LinkedList<>();
        this.pageSize = 0;
    }

    public Page(LinkedList<E> pl, int pms, int ps) {
        this.pageList = pl;
        this.pageMaxSize = pms;
        this.pageSize = ps;
    }

    public LinkedList<E> getPageList() {
        return pageList;
    }

    /**
     * @return page.size() including element 0 or 1
     */
    public int size() {
        return pageList.size();
    }

    /**
     * @return page.pageSize
     */
    public int realSize() {
        int size = 0;
        Iterator<E> pIter = pageList.iterator();
        while (pIter.hasNext() && pIter.next().delBit != 1) {
            size++;
        }
        return pageSize = size;
    }


    /**
     * get pct of dirty node in pageList
     *
     * @return
     */
    public int getDirtyPct() {
        return (size() - realSize()) * 100 / pageMaxSize;
    }

    /**
     * get pos for insert node x
     *
     * @param x
     * @return
     */
    public E getInsertPos(LinkedList<E> le, E x) {
        Iterator<E> leIter = le.iterator();
        E curCell = null;
        while (leIter.hasNext()) {
            curCell = leIter.next();
            if (x.key > curCell.key) {
                break;
            }
        }
        return curCell;
    }

    /**
     * insert x into linkedlist le orderly
     *
     * @param le linkedlist
     * @param x  element
     */
    private void insert(LinkedList<E> le, E x) {
        if (x.key > le.peekFirst().key
                && x.key < le.peekLast().key) {
            le.add(le.indexOf(getInsertPos(le, x)), x);
            pageSize++;
        }
    }

    /**
     * insert x into pageList
     *
     * @param x
     */
    public void insert(E x) {
        insert(pageList, x);
    }

    /**
     * remove x from pageList
     *
     * @param x
     */
    public void delete(E x) {
//        if(pageList.size() == pageMaxSize/2) {
//            pageList.remove(x);
//        } else if(pageList.size() > pageMaxSize/2) {
//            pageList.remove(x);
//        }
        if (pageList.contains(x)) {
            pageList.remove(x);
            pageSize--;
        }
    }

    public BTreeNode getNode(E x) {
        return pageList.get(1);
    }

    /**
     * if pageList.size() equals to pageMaxSize, split it into two part
     *
     * @return new Page
     */
    public Page<E> split() {
        LinkedList<E> slist = null;
        if (pageList.size() == pageMaxSize) {
            while (pageList.get(pageMaxSize / 2) != null) {
                slist.add(pageList.remove(pageMaxSize / 2));
            }
        }
        return new Page(slist, pageMaxSize, pageMaxSize / 2);
    }

    /**
     * getFirstNode
     *
     * @return
     */
    public E getFirstNode() {
        return pageList.getFirst();
    }

    /**
     * return parentNode
     *
     * @return
     */
    public BTreeNode getParentNode() {
        return pageList != null ? pageList.getFirst().parent : null;
    }


    /**
     * if pare.node.delBit equals to 1, remove it from linked list;
     */
    public void purgePage() {
        Iterator<E> pIter = pageList.iterator();
        E curCell = null;
        while (pIter.hasNext()) {
            curCell = pIter.next();
            if (curCell.delBit == 1) {
                pageList.remove(curCell);
            }
        }
    }

    /**
     * The purge action will happen while two cases happen, one is
     * dirty-node-pct is bigger than HIGH_WATER; the other when pageList
     * was full;
     */
    public void clearDirtyPage() {
        if (getDirtyPct() > HIGH_WATER || size() == pageMaxSize) {
            purgePage();
        }
    }

    /**
     * merge two page to assume that elements of linkedlist are realNode
     * perhaps func merge should be put in BTree
     *
     * @return final list
     */
    public LinkedList<E> merge(LinkedList<E> pl) {
        if (pl.size() + pageList.size() > pageMaxSize) {
            throw new RuntimeException("The two page can not be merged");
        }

        LinkedList<E> tmpList = null;
        if (pl.getLast().key < pageList.getFirst().key) {
            pl.addAll(pageList);
            pageList.getFirst().parent.setDelBit();
            pageList.getFirst().parent = null;
            pageList.clear();
            tmpList = pl;
        } else if (pl.getFirst().key > pageList.getLast().key) {
            pageList.addAll(pl);
            pl.getFirst().parent.setDelBit();
            pl.getFirst().parent = null;
            pl.clear();
            tmpList = pageList;
        }
        return tmpList;
    }

    /**
     * clear page.pageList
     */
    public void clear() {
        Iterator<E> pIter = pageList.iterator();
        while (pIter.hasNext()) {
            E curpNode = pIter.next();
            curpNode.clear();
        }
    }
}
