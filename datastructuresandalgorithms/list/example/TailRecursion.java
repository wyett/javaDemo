package datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/2 16:41
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class TailRecursion<E> {
    public static <E> void printList(Iterator<E> itr) {
        /**
        if(!itr.hasNext()) {
            return;
        }
        System.out.println(itr.next());
        printList(itr);
         */

        while(true) {
            if(!itr.hasNext()) {
                return;
            }
            System.out.println(itr.next());
        }
    }
}
