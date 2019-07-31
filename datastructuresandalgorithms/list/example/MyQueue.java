package datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/31 20:54
 * @description: queue by ArrayList
 */

public class MyQueue<E> {
    private MyArrayList<E> mle = new MyArrayList<E>();

    /**
     * @param e add element at high pos
     */
    public void add(E e) {
        mle.add(e);
    }

    /**
     * @return
     */
    public E remove() {
        if(mle != null && mle.size() > 0) {
            return mle.remove(0);
        }
        return null;
    }

    /**
     * @return
     */
    public int size() {
        return mle.size();
    }
}
