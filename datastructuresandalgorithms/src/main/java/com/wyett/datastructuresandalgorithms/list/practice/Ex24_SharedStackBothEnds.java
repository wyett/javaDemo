package com.wyett.datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 12:54
 * @description: two stack implemented in one array by
 * one from low to high and another from high
 * to low;
 */

public class Ex24_SharedStackBothEnds<E> {
    // array items
    private Object[] items;
    // top pos of first stack
    private int pos1;
    // top pos of second stack
    private int pos2;
    // size of stack;
    private int theSize;


    public Ex24_SharedStackBothEnds(int s) {
        this.items = new Object[theSize];
        this.pos1 = -1;
        this.pos2 = theSize;
        this.theSize = s;
    }


    public boolean isEmpty() {
        return (pos1 < 0 && pos2 >= theSize ? true : false);
    }

    public void push(E x, int snum) {
        // check if stack is full
        if (pos1 + pos2 == theSize) {
            throw new RuntimeException();
        }

        // push
        if (snum == 1) {
            items[++pos1] = x;
        } else if (snum == 2) {
            items[--pos2] = x;
        }
    }

    public E pop(int snum) {
        E elem = null;
        if (snum == 1 && pos1 >= 0) {
            elem = (E) items[pos1--];
        } else if (snum == 2 && pos2 < theSize) {
            elem = (E) items[pos2++];
        }
        return elem;
    }

    public E peek(int snum) {
        E elem = null;
        if (snum == 1 && pos1 >= 0) {
            elem = (E) items[pos1];
        } else if (snum == 2 && pos2 < theSize) {
            elem = (E) items[pos2];
        }
        return elem;
    }

    public int size(int snum) {
        return pos1 + 1 + theSize - pos2;

    }

    @Override
    public String toString() {
        String stack1 = "";
        String stack2 = "";
        if (pos1 > -1) {
            for (int i = 0; i <= pos1; i++) {
                stack1 += (i == 0 ? items[i] : ", " + items[i]);
            }
        }
        if (pos2 < theSize) {
            for (int i = theSize - 1; i >= pos2; i++) {
                stack2 += ((i == theSize - 1) ? items[i] : "," + items[2]);
            }
        }
        return "stack1: " + stack1 + "\nstack2: " + stack2;
    }
}
