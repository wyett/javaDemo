package datastructuresandalgorithms.tree.struct.BTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/20 17:27
 * @description: nodes bellow a same parent node is a page
 */

public interface Page<E>{
    /**
     * insert item into page sequentially
     * @param le page
     * @param item the node value
     */
    void insert(List<E> le, E item);

    /**
     * sine item as deleted in page
     * @param le page to delete from
     * @param item item to be delete
     */
    void delete(List<E> le, E item);

    /**
     * split page le into two page
     * @param le original page
     * @return
     */
    List<E> split(List<E> le);

    /**
     * combine page logically
     * @param le1 from le1
     * @param le2 to le2
     * @return le2
     */
    List<E> combine(List<E> le1, List<E> le2);

    /**
     * delete item physically from page le
     * @param le
     * @param item
     */
    void purge(List<E> le, E item);
}
