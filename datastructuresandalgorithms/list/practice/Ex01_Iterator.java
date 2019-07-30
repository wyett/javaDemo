package datastructuresandalgorithms.list.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/30 16:48
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex01_Iterator<E> {
    public static <E>
    void printLot(List<E> l, List<Integer> p) {
        Iterator<E> lIterator = l.iterator();
        Iterator<Integer> pIterator = p.iterator();

        List<E> lList = new ArrayList<>() ;
        Integer pItem = 0;
        int start = 0;

        while(lIterator.hasNext() && pIterator.hasNext()) {
            pItem = pIterator.next();
            while(start < pItem && lIterator.hasNext()) {
                start++;
                lIterator.next();
            }
            lList.add(lIterator.next());
            start++;
        }
        System.out.println(lList);
    }
    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8, 9,10));
        ArrayList<Integer> P = new ArrayList<>(Arrays.asList(0,1,2,6,9,10));
        printLot(L, P);
    }
}
