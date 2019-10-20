package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 19:45
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class IteratorPrint {
    public static <AnyType> void print(Collection<AnyType> coll) {
        Iterator<AnyType> itr
                = (Iterator<AnyType>) coll.iterator();
        while (itr.hasNext()) {
            AnyType item = itr.next();
            System.out.println(item);
        }
    }
}
