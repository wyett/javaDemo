package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 19:37
 * @description: TODO
 * @modified By:
 * @version: $
 */

public interface Collection<AnyType> extends Iterable<AnyType> {
    int size();

    boolean isEmpty();

    void clear();

    boolean contains(AnyType x);

    boolean add(AnyType x);

    boolean remove(AnyType x);

    java.util.Iterator<AnyType> iterator();
}
