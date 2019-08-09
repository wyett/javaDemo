package datastructuresandalgorithms.list.practice;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/9 10:25
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex31_SingleLinkedListStack<E> {
    private SinglyListWithnotEnd<E> stack;
    public Ex31_SingleLinkedListStack(SinglyListWithnotEnd<E> stack) {
        this.stack = stack;
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(E x) {
        stack.add(x);
    }

    public E pop() {
        return stack.removeLast();
    }

    public E peek() {
        return stack.getLast();
    }
}
