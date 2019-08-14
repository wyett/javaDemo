package datastructuresandalgorithms.tree.struct.BinaryTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/14 15:47
 * @description: binary tree node type
 */

public class BinaryNode<E> {
    public E data;
    public BinaryNode<E> left;
    public BinaryNode<E> right;

    public BinaryNode(E d) {
        this(d, null, null);
    }

    public BinaryNode(E d, BinaryNode<E> lt, BinaryNode<E> rt) {
        this.data = d;
        this.left = lt;
        this.right = rt;
    }
}
