package datastructuresandalgorithms.tree.struct.BinarySearchTree;

import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/14 11:18
 * @description: Binary Search tree is the tree witch has
 *               leftNode.data is less than parentNode.data
 *               and rightNode.data is greater than it's parentNode.data
 *               leftNode.data < parentNode.data < rightNode.data
 */

public class BinarySearchTree<E extends Comparable<? super E>> {
    private BSNode<E> root;

    /**
     * default constructor
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * constructor with init root
     * @param root
     */
    public BinarySearchTree(BSNode<E> root) {
        this.root = root;
    }

    /**
     * clear tree
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * check if tree is empty
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    public BSNode<E> getRoot() {
        return root;
    }

    /**
     * check if x is contained in the whole tree
     * @param x
     * @return
     */
    public boolean contains(E x) {
        return contains(x, root);
    }

    /**
     * check if x is contained in a subtree
     * @param x data to check
     * @param startNode child tree's root node
     * @return
     */
    private boolean contains(E x, BSNode<E> startNode) {
        if(startNode == null) {
            return false;
        }

        int compareResult = x.compareTo(startNode.getData());

        if(compareResult < 0 ) {
            return contains(x, startNode.getLeft());
        } else if (compareResult > 0) {
            return contains(x, startNode.getRight());
        } else {
            return true;
        }
    }

    /**
     * find the minest node in the tree
     * @return
     */
    public E findMin() {
        return findMin(root).getData();
    }

    /**
     * find the minest node in a subtree
     * @param startNode the root node of subtree
     * @return
     */
    private BSNode<E> findMin(BSNode<E> startNode) {
        if(startNode == null) {
            return null;
        }

        if(startNode.getLeft() == null) {
            return startNode;
        }
        return findMin(startNode.getLeft());
    }

    /**
     * find minest node in a subtree without recursion
     * @param startNode
     * @return
     */
    private BSNode<E> findMinWithoutRecursion(BSNode<E> startNode) {
        BSNode<E> tmpNode = startNode;
        if(tmpNode == null) {
            return null;
        } else {
            while (tmpNode.getLeft() != null) {
                tmpNode = tmpNode.getLeft();
            }
            return tmpNode;
        }
    }

    /**
     * find the max node in the whole tree
     * @return
     */
    public E findMax() {
        return findMax(root).getData();
    }

    /**
     * find max node in a subtree
     * @param startNode root node of the subtree
     * @return
     */
    private BSNode<E> findMax(BSNode<E> startNode) {
        if(startNode == null) {
            return null;
        }

        if(startNode.getRight() == null) {
            return startNode;
        }
        return findMax(startNode.getRight());

    }

    /**
     * find max node in a subtree without recursion
     * @param startNode
     * @return
     */
    private BSNode<E> findMaxWithoutRecursion(BSNode<E> startNode) {
        BSNode<E> tmpNode = startNode;
        if(tmpNode == null) {
            return null;
        } else {
            while(tmpNode.getRight() != null) {
                tmpNode = tmpNode.getRight();
            }
            return tmpNode;
        }
    }

    /**
     * add node with x in the tree
     * @param x
     */
    public void insert(E x) {
        insert(x, root);
    }

    /**
     * add node with x in subtree with root node n
     * @param x
     * @param n
     * @return
     */
    public BSNode<E> insert(E x, BSNode<E> n) {
        BSNode<E> tmpNode = n;
        if(tmpNode == null) {
            return tmpNode = new BSNode<E>(x, null, null);
        }

        int compareResult = x.compareTo(tmpNode.getData());
        if(compareResult < 0) {
            tmpNode.setLeft(insert(x, tmpNode.getLeft()));
        } else if (compareResult > 0) {
            tmpNode.setRight(insert(x, tmpNode.getRight()));
        } else {}

        return tmpNode;
    }

    /**
     * remove from tree
     * @param x
     */
    public void remove(E x) {
        remove(x, root);
    }

    /**
     * remove from a subtree
     * @param x the node to remove
     * @param n the node that roots the subtree;
     * @return the new root of the subtree
     */
    public BSNode<E> remove(E x, BSNode<E> n) {
        BSNode<E> tmpNode = n;
        if(tmpNode == null) {
            return tmpNode;
        }

        int compareResult = x.compareTo(tmpNode.getData());
        if(compareResult < 0) {
            tmpNode.setLeft(remove(x, tmpNode.getLeft()));
        } else if (compareResult > 0) {
            tmpNode.setRight(remove(x, tmpNode.getRight()));
        } else if(tmpNode.getLeft()!= null && tmpNode.getRight()!= null) {
            tmpNode.setData(findMin(tmpNode.getRight()).getData());
            tmpNode.setRight(remove(tmpNode.getData(), tmpNode.getRight()));
        } else {
            tmpNode = (tmpNode.getRight() != null)
                    ? tmpNode.getLeft(): tmpNode.getRight();
        }
        return tmpNode;
    }

    /**
     * print tree
     */
    public void printTree() {
        printTree(root);
    }

    /**
     * print subtree
     * @param n
     */
    private void printTree(BSNode<E> n) {
        if (n == null) {
            throw new NoSuchElementException();
        }

        BSNode<E> curNode = n;
        System.out.println(curNode.getData());
        if(n.getLeft() != null) {
            printTree(curNode.getLeft());
        } else if(n.getRight() != null) {
            printTree(curNode.getRight());
        }
    }
}




