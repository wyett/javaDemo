package datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 16:13
 * @description: Array Object[] items implements two or more Stack both from
 *               low to high pos, each element has a flag identifying which
 *               stack it belongs to
 */

public class Ex24_SharedStackBothLowToHigh<E> {
    private class StackElem<E> {
        private E data;
        private byte bitPos;

        public StackElem(E d, byte bitPos) {
            this.data = d;
            this.bitPos = bitPos;
        }
    }
    private StackElem<E>[] items;
    private int theSize;
    private int pos;

    @SuppressWarnings("unchecked")
    public Ex24_SharedStackBothLowToHigh(int theSize) {
        this.theSize = theSize;
        this.items = new StackElem[theSize];
        this.pos = -1;
    }

    public int size(int snum) {
        int tmpCount = 0;
        for(int i = 0; i < pos; i++) {
            if(items[i].bitPos == snum) {
                tmpCount++;
            }
        }
        return tmpCount;
    }


    public void push(E x, int snum) {
        if(pos > theSize) {
            throw new IndexOutOfBoundsException();
        }
        items[++pos] = new StackElem<E>(x, (byte)snum);
    }

    /**
     * pop element.data when bitPos is snum, and at the end of this stack;
     * then, purge items
     * @param snum
     * @return
     */
    public E pop(int snum) {
        int count = pos;
        E res = null;
        for(int i = pos; i > -1; i--) {
            if(items[i].bitPos == snum) {
                res = items[i].data;
                items[i] = null;
            }
            purge(i);
            break;
        }

        return res;
    }

    /**
     * purge null element
     * @param s
     */
    public void purge(int s) {
        for(int i = s; i < pos; i++) {
            if (items[i] == null && items[i+1] != null) {
                items[i] = items[i+1];
                items[i+1] = null;
            }
        }
        pos--;
    }

    public E peek(int snum) {
        int count = pos;
        E res = null;
        for(int i = pos; i > -1; i--) {
            if(items[i].bitPos == snum) {
                res = items[i].data;
            }
        }

        return res;
    }

    public boolean isEmpty(int snum) {
        return size(snum) == 0;
    }
}
