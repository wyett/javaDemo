package com.wyett.datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/6 17:13
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex17_MyArrayList<E> implements Iterable<E> {
    private int theSize;
    private E[] theItems;

    /**
     * clear ArrayList
     */
    public Ex17_MyArrayList() {
        doClear();
    }

    public void doClear() {
        clear();
    }

    public void clear() {
        theSize = 0;
        theItems = null;
    }

    /**
     * check if ArrayList is emyty
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * add element x
     *
     * @param x
     */
    public void add(E x) {
        add(theSize++, x);
    }

    /**
     * add x at pos idx
     *
     * @param idx
     * @param x
     */
    public void add(int idx, E x) {
        if (idx > theSize - 1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theSize++;
    }

    /**
     * add ArrayList
     *
     * @param itr
     */
    public void addAll(Iterable<? extends E> itr) {
        java.util.Iterator<? extends E> tmpItr = itr.iterator();
        while (tmpItr.hasNext()) {
            add(tmpItr.next());
            theSize++;
        }
    }

    public void set(int idx, E x) {
        if (idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
        theItems[idx] = x;
    }

    public int size() {
        return theSize;
    }


    public E get(int idx) {
        if (idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    /**
     * remove idx element from ArrayList
     *
     * @param idx
     */
    public void remove(int idx) {
        if (idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = idx; i < theSize; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
    }

    public boolean contains(E x) {
        for (int i = 0; i < theSize; i++) {
            if (get(i).equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current;

        @Override
        public boolean hasNext() {
            return current != theSize;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            if (current > 0) {
                throw new IndexOutOfBoundsException();
            }
            Ex17_MyArrayList.this.remove(--current);
        }
    }

    public java.util.Iterator<E> reverseIterator() {
        return new ArrayListReverseIterator();
    }

    private class ArrayListReverseIterator implements java.util.Iterator<E> {
        private int current = theSize;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return theItems[--current];
        }

        @Override
        public void remove() {
            Ex17_MyArrayList.this.remove(--current);
        }
    }

    public java.util.ListIterator<E> listIterator() {
        return new ArrayListListIterator();
    }

    private class ArrayListListIterator implements java.util.ListIterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current != theSize;
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return theItems[current++];
        }

        @Override
        public E previous() {
            if (hasPrevious()) {
                throw new IndexOutOfBoundsException();
            }
            return theItems[--current];
        }

        @Override
        public void set(E x) {
            Ex17_MyArrayList.this.set(current, x);
        }

        @Override
        public void add(E x) {
            Ex17_MyArrayList.this.add(current++, x);
        }

        @Override
        public void remove() {
            Ex17_MyArrayList.this.remove(--current);
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }


}


