package com.wyett.datastructuresandalgorithms.tree.struct;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/13 19:27
 * @description: Tree
 */

public class GenericTree<E> {
    /**
     * tree node
     */
    private class TreeNode<E> {
        E element;
        TreeNode<E> firstChild;
        TreeNode<E> nextSibling;
    }

//    String printName() {
//        System.out.println(TreeNode.element.class.getName());
//    }
//    private void listAll(int depth) {
//        printName(depth);
//        if(isDirectory()) {
//            c.listAll(depth + 1);
//        }
//    }

}
