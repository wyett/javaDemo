package datastructuresandalgorithms.tree.struct.BTree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/20 18:17
 * @description: PageImpl implemented Page, with element Item<E> orgornized
 *               by LinkedList
 */

public class PageImpl<E extends Cell> implements Page<E extends Cell> {
    private LinkedList<E> pageList;
    private int pageSize;

    PageImpl(int pageSize) {
        this.pageSize = pageSize;
        this.pageList= new LinkedList<>();
    }

    /**
     * add element x into list sequentially
     * if list is full, split it into two list
     * else
     * @param le
     * @param x
     */
    private void insert(LinkedList<E> le, E x) {
        if(le.size() == (pageSize - 1)) {
            // if le.size == pageSize - 1, add x and split it into two
        }else if(le.size() > pageSize/2 && le.size() < (pageSize - 1)) {
            // add x
        }
    }

    public void insert(E x) {
        insert(pageList, x);
    }




}
