package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/31 15:50
 * @description: by ArrayList
 */

public class Ex06_Josephus {
    /**
     * @param m pass m times
     * @param n people
     */
    public static List<Integer> pass(int m, int n) {
        //init resultList
        List<Integer> resultList = new ArrayList<Integer>();

        /** mPrime, start number */
        int mStart, numLeft, interval, currentPos, elemToRemove;

        /** init list */
        ArrayList<Integer> L = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            L.add(i);
        }

        //init mStart, get first element of L
        mStart = L.get(0);
        //init numLeft
        numLeft = n;

        while (numLeft-- > 1) {
            interval = m % (numLeft + 1);
            currentPos = getIdByElement(L, mStart);
            if ((currentPos + interval + 1) < L.size()) {
                elemToRemove = L.get(currentPos + interval);
                resultList.add(elemToRemove);
                mStart = L.get(currentPos + interval + 1);
                L.remove(currentPos + interval);
                System.out.println("<:" + L);
            } else if ((currentPos + interval + 1) == L.size()) {
                elemToRemove = L.get(numLeft);
                resultList.add(elemToRemove);
                mStart = L.get(0);
                L.remove(numLeft);
                System.out.println("=" + L);
            } else {
                elemToRemove = L.get(currentPos + interval - numLeft);
                resultList.add(elemToRemove);
                mStart = L.get(currentPos + interval - numLeft + 1);
                L.remove(currentPos + interval - numLeft);
                System.out.println(">" + L);
            }
        }
        return resultList;
    }

    /**
     * get pos of elem in List, only if there no equal element in li
     *
     * @param li   ArrayList
     * @param elem element need to check
     * @return pos of element
     */
    private static int getIdByElement(List<Integer> li, int elem) {
        int idx = 0;
        Iterator<Integer> ll = li.iterator();
        while (ll.hasNext()) {
            idx++;
            if (ll.next() == elem) {
                break;
            }
        }
        return (idx - 1);
    }

    public static void main(String[] args) {
        System.out.println(pass(13, 5));
    }
}
