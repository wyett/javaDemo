package datastructuresandalgorithms.list.example;

import java.util.ListIterator;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 20:01
 * @description: List ADT两种实现: ArrayList/LinkedList
 * LinkedList的优点:新项插入和现有项删除开销很小,
 *          缺点:不易操作索引
 * ArrayList优点：get和set话费常数时间，增删代价昂贵
 */

public interface List<AnyType> extends Collection<AnyType> {
    // 0表示表最前端，size()-1表示最后一项
    AnyType get(int x);
    AnyType set(int idx, AnyType newVal);
    void add(int idx, AnyType x);
    void remove(int idx);

    ListIterator<AnyType> listIterator(int pos);
}
