package com.wyett.datastructuresandalgorithms.tree.example.BTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/21 18:08
 * @description: TODO
 */

public class BTreeNode<E extends Cell> {
    // index of node
    public int key;
    // if this node is deleted
    public byte delBit;
    // parent of the first node in linkedlist, other's are null
    public BTreeNode<E> parent;
    // child node, leaf nodes child pointed to null
    public BTreeNode<E> child;
    //    public Page<BTreeNode<E>> child;
    // data of leaf;
    public E data;

    // non-leaf node
//    public BTreeNode(int key, BTreeNode p, BTreeNode c) {
    public BTreeNode(int key) {
        this.key = key;
        this.delBit = (byte) 0;
        this.parent = null;
        this.child = null;
    }

    // leaf node
    public BTreeNode(int key, E d) {
        this.key = key;
        this.delBit = (byte) 0;
        this.parent = null;
        this.data = d;
    }

    public void setDelBit() {
        this.delBit = (byte) 1;
    }

    public byte getDelBit() {
        return this.delBit;
    }

    public void clear() {
        this.key = -1;
        this.setDelBit();
        this.parent = null;
        this.child = null;
        this.data = null;
    }
}
