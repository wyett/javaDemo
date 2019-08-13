package datastructuresandalgorithms.list.practice;

import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/13 10:30
 * @description: Circle array
 */

public class Ex33_CircleArrayQueue<E> {
    // the begin pos
    private int front = 0;
    // the end pos
    private int rear = 0;
    private E[] arr;
    // size of arr
    private int arrSize;

    @SuppressWarnings("unchecked")
    public Ex33_CircleArrayQueue(int arrSize) {
        this.arrSize = arrSize;
        this.arr = (E[])new Object[this.arrSize];
    }

    /**
     * array is empty while front equals rear;
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * check whether array is full
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % arrSize == front;
    }

    /**
     * get element count from
     * @return
     */
    public int getSize() {
        return rear - front + 1;
    }

    /**
     * add element at arr[rear], and rear++
     * @param elem
     */
    public void push(E elem) {
        while(!isFull()) {
            if(rear < arrSize) {
                arr[++rear] = elem;
            } else {
                arr[rear -= arrSize] = elem;
            }
        }
    }

    /**
     * pop from arr[front], if front is greater than arrSize - 1, set front as
     * zero, else front++
     * @return
     */
    public E pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        E tmpVal = arr[front];
        front = (front + 1 >= arrSize) ? ++front - arrSize: ++front;

        return tmpVal;
    }
}
