package datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 19:43
 * @description: 如果对正在被迭代的集合进行结构上的变更(对集合add, remove(不是Iterator自己的方法),clear)，
 *          那么迭代器就不再合法，并且在其后会抛出ConcurrentModificationException
 *          异常抛出
 * @modified By:
 * @version: $
 */

public interface Iterator<AnyType> {
    boolean hasNext();
    AnyType next();
    // Iterators.remove()优点
    // 不用找出要被删除的项
    void remove();
}
