package datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/9 18:31
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex31_SinglyListWithnotEndQueue<E> {
    private SinglyListWithnotEnd<E> queue;
    public Ex31_SinglyListWithnotEndQueue(SinglyListWithnotEnd<E> queue) {
        this.queue = queue;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void push(E x) {
        queue.add(x);
    }

    public E peek() {
        return queue.get(0);
    }

    public E pop() {
        return queue.removeFirst();
    }
}
