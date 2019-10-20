package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 19:41
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class CollectionPrint1 {
    public static <AnyType> void print(Collection<AnyType> coll) {
        for (AnyType item : coll) {
            System.out.println(item);
        }
    }
}
