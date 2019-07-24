package datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 20:27
 * @description: for search, both ArrayList and LinkedList is inefficient
 *
 * @modified By:
 * @version: $
 */

public class ListBuilder {
    /** add at the end
     *  No matter weather ArrayList or LinkedList ，O(N)
     * */
    public static void makeList1(List<Integer> lst, int N) {
        lst.clear();
        for(int i = 0; i < N; i++) {
            lst.add(i);
        }
    }
    /** add at the start
     *  ArrayList, O(N^2), because add first elem cost O(N)
     *  LinkedList, O(N)
     * */
    public static void makeList2(List<Integer> lst, int N) {
        lst.clear();
        for(int i = 0; i < N; i++){
            lst.add(0, i);
        }
    }
    /** caculate sum of all elements in List
     *  ArrayList, O(N)
     *  LinkedList, O(N^2), because get() cost O(N)
     * */
    public static int sum(List<Integer> lst) {
        int total = 0;
        for(int i = 0; i < N; i++) {
            total += lst.get();
        }
        return total;
    }
    /**
     *  ArrayList, remove(i), O(N)
     *  LinkedList, get(i), O(N)
     *  对两种都是 O(N^2)
     * */
    public static void removeEvensVer1(List<Integer> lst) {
        int i = 0;
        while(i < lst.size())
            if(lst.get(i) % 2 == 0)
                lst.remove(i);
            else
                i++;
    }
    /**
     *   Collection.remove(), 时间复杂度为O(N)
     *   由于ConcurrentModificationException异常无法运行
     * */
    public static void removeEvensVer2(List<Integer> lst) {
        for(Integer x: lst) {
            if(x % 2 == 0)
                lst.remove(x);
        }
    }

    /**
     * ArrayList, O(N^2)
     * LinkedList, O(N)
     * @param lst
     */
    public static void removeEvensVer3(List<Integer> lst) {
        Iterator<Integer> itr = (Iterator<Integer>)lst.iterator();
        while(itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
    }
}
