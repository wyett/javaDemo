package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/31 20:34
 * @description: MyStack by ArrayList
 */

public class MyStack<E> {
    private MyArrayList<E> me;

    public MyStack() {
        this.me = new MyArrayList<>();
    }

    /**
     * @param elem to be push into mystack
     */
    public void push(E elem) {
        me.add(elem);
    }

    /**
     * @return top of stack and tail of ArrayList
     */
    public E pop() {
        if (me != null && me.size() > 0) {
            return me.remove(me.size() - 1);
        }
        return null;
    }

    /**
     * @return top of stack
     */
    public E top() {
        if (me != null && me.size() > 0) {
            return me.get(me.size() - 1);
        }
        return null;
    }

    /**
     * @return size of stack
     */
    public int size() {
        return me.size();
    }

}
