package datastructuresandalgorithms.tree.struct.AVLTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/16 15:36
 * @description: TODO
 */

public class AVLNode<E> {
    private E data;
    private AVLNode<E> left;
    private AVLNode<E> right;
    private int height;

    public AVLNode(E d) {
        this(d, null, null);
    }

    public AVLNode(E d, AVLNode<E> lt, AVLNode<E> rt) {
        this.data = d;
        this.left = lt;
        this.right = rt;
        this.height = 0;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public void setLeft(AVLNode<E> left) {
        this.left = left;
    }

    public AVLNode<E> getLeft() {
        return this.left;
    }
    public void setRight(AVLNode<E> right) {
        this.right = right;
    }

    public AVLNode<E> getRight() {
        return this.right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }
}
