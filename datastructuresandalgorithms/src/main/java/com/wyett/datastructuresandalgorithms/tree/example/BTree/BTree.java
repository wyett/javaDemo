package com.wyett.datastructuresandalgorithms.tree.example.BTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/20 16:07
 * @description: M-order balance tree has following features
 * (1) data is on the leaf node
 * (2) The searching direstion was pointed by M-1 key words on
 * non-leaf nodes
 * (3) The count of Node is between 2 and M whether root or
 * leaf nodes;
 * (4) All of the non-leaf nodes has child node number range from
 * M/2 to M, except the root node
 * (5) All of the leaf node has the same depth, which has between
 * L/2 and L items. L is the max count in the leaf
 * (6) The root node can have two child node at least
 */

public class BTree<E extends Cell> {
    // order of tree, M
    private int order;
    private Page root;
    private Stack<Integer> keyStack;

    public BTree(int order) {
        this.order = order;
        root = null;
        keyStack = new KeyBuilder(10).putKeysIntoStack();
    }

    public Page getRoot() {
        return root;
    }

    /**
     * create root node linkedList with order node;
     */
    public void createRoot() {
        root = new Page(order);
    }

    /**
     * get key value
     *
     * @return
     */
    public int getkey() {
        if (keyStack.isEmpty()) {
            keyStack = new KeyBuilder(10).putKeysIntoStack();
        }
        return keyStack.peek();
    }

    /**
     * create non-leaf node
     *
     * @param key
     * @return
     */
    public BTreeNode createNonLeafBTreeNode(int key) {
        return new BTreeNode(key);
    }

    /**
     * create leaf node
     *
     * @param key
     * @param x   cell data
     * @return
     */
    public BTreeNode createLeafBTreeNode(int key, E x) {
        return new BTreeNode(key, x);
    }

    /**
     * add x into tree
     *
     * @param x
     */
    public void add(Page<BTreeNode<E>> p, E x) {
        int newKey = getkey();
        BTreeNode nonLeafNode = createNonLeafBTreeNode(newKey);
        BTreeNode leafNode = createLeafBTreeNode(newKey, x);

        p.insert(nonLeafNode);
        nonLeafNode.child = leafNode;
        leafNode.parent = nonLeafNode;

        // try to shrink page
        p.clearDirtyPage();

        // if p is full, split it
        if (p.size() == order) {
//            add(p.getParentNode(), p.split().getFirstNode());
        }
    }


    //    public Page<BTreeNode<E>> findPage(int key) {
    public void findPage(int key) {
        Page<BTreeNode<E>> PageToSearch = getRoot();
        Iterator<BTreeNode<E>> iter = PageToSearch.getPageList().iterator();
        BTreeNode<E> tmp = null;

        while (iter.hasNext()) {
            tmp = iter.next();
            if (tmp.key >= key) {
                break;
            }
        }
//        PageToSearch = tmp.child;

    }

    public void addPage(Page<BTreeNode<E>> p) {
    }


//    public void remove() {}

//    public Page merge() {}


}
