package datastructuresandalgorithms.list.practice;

import java.util.SortedSet;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 18:40
 * @description: Sorted Stack with the smallest element at the top, add function
 *               findMin and deleteMin
 */

public class Ex25_SortedStack<E extends Comparable<? super E>> {
    private Object[] items;
    private int theSize;
    private int pos;

    public Ex25_SortedStack(int theSize) {
        this.theSize = theSize;
        items = new Object[theSize];
        pos = -1;
    }

    public boolean isEmpty() {
        return pos >= 0;
    }

    public int size() {
        return pos < 0 ? 0 : pos + 1;
    }

    /**
     * push x into sorted stack with smallest element at the top
     * @param x
     */
    @SuppressWarnings("unchecked")
    public void push(E x) {
        if(x.compareTo((E)items[pos]) < 0) {
            items[++pos] = x;
        } else {
            E tmpItems = null;
            int cur = pos;
            while(x.compareTo((E)items[cur]) > 0) {
                items[cur + 1] = items[cur];
                items[cur] = null;
                cur--;
            }
            items[cur] = x;
            pos++;
        }

    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if(pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) items[pos--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E)items[pos];
    }

    public E findMin() {
        return peek();
    }

    public E deleteMin() {
        return pop();
    }
}
