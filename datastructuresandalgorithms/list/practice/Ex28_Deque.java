package datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 19:28
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex28_Deque<E> {
    private Object[] items;
    private int theSize;
    private int pos = 0;

    public Ex28_Deque(int theSize) {
        this.theSize = theSize;
        this.items = new Object[theSize];
    }

    /**
     * add x at the front, O(n)
     * @param x
     */
    public void push(E x) {
        if(pos >= theSize) {
            throw new RuntimeException("full");
        }

        if(pos < 0) {
            items[0] = x;
        }

        for(int i = pos; i >= 0; i--) {
           items[i+1] = items[i];
        }
        items[0] = x;
        pos++;
    }

    /**
     * delete from the front, O(n)
     * @return
     */
    public E pop() {
        E tmpElem = null;
        if(pos >= theSize || pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        tmpElem = (E)items[0];
        if(pos-- == 0) {
            items[0] = null;
        } else if(pos > 0) {
            for(int i = 0; i < pos; i++) {
                items[i] = items[i + 1];
            }
            items[pos] = null;
            pos--;
        }

        return tmpElem;
    }

    public void inject(E x) {
        items[++pos] = x;
    }

    public E eject() {
        E tmpElem = (E)items[pos];
        items[pos--] = null;
        return tmpElem;
    }
}
