package datastructuresandalgorithms.tree.struct.BinarySearchTree;

import datastructuresandalgorithms.tree.struct.BinaryTree.BinaryNode;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/15 10:23
 * @description: binary search tree node
 */

public class BSNode<E> {
    private E data;
    private BSNode<E> left;
    private BSNode<E> right;

    public BSNode(E d, BSNode<E> lt, BSNode<E> rt) {
        this.data = d;
        this.left = lt;
        this.right = rt;
    }

    public BSNode(E d) {
        this(d, null, null);
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setLeft(BSNode<E> lt) {
        this.left = lt;
    }

    public BSNode<E> getLeft() {
        return this.left;
    }

    public void setRight(BSNode<E> rt) {
        this.right = rt;
    }

    public BSNode<E> getRight() {
        return this.right;
    }
}
