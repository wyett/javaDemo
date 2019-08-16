package datastructuresandalgorithms.tree.struct.AVLTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/16 15:36
 * @description: adelson-velskii and landis tree is a binary search tree with
 *               balance condition, it's time-complexity is O(logN), which
 *               has height difference between left-child tree and right-child
 *               tree is at most one; each node has it's height; while in the
 *               AVLtree with h height, it has S(h) = s(h-1) + S(h-2) + 1 nodes.
 */

public class AVLTree<E extends Comparable<? super E>> {
    // balance factor
    private static final int ALLOWED_IMBALANCE = 1;
    // root node
    private AVLNode<E> root;
    public AVLTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(AVLNode<E> n) {
        return n == null ? -1 : n.getHeight();
    }

    /**
     * insert item in the tree
     * @param x
     */
    public void insert(E x) {
        root = insert(x, root);
    }

    /**
     * insert into a subtree;
     * @param x the item to insert
     * @param n the node that roots the subtree
     * @return the new root of the subtree
     */
    private AVLNode<E> insert(E x, AVLNode<E> n) {
        if(n == null) {
            return new AVLNode<E>(x, null, null);
        }

        int compareResult = x.compareTo(n.getData());
        if(compareResult < 0) {
            n.setLeft(insert(x, n.getLeft()));
        } else if(compareResult > 0) {
            n.setRight(insert(x, n.getRight()));
        } else {}

        return balance(n);
    }

    /**
     * remove x from tree
     * @param x
     */
    public void remove(E x) {
        root = remove(x, root);
    }

    /**
     * remove item x from subtree
     * @param x item to be removed
     * @param n root node of subtree
     * @return new root of subtree;
     */
    private AVLNode<E> remove(E x, AVLNode<E> n) {
        if(n == null) {
            return n;
        }

        int compareResult = x.compareTo(n.getData());
        if(compareResult < 0) {
            n.setLeft(remove(x, n.getLeft()));
        } else if (compareResult > 0) {
            n.setRight(remove(x, n.getRight()));
        } else {
            n = (n.getLeft()!= null) ? n.getLeft(): n.getRight();
        }

        return balance(n);
    }

    /**
     * balance subtree
     * @param n root of subtree
     * @return new root of subtree
     */
    private AVLNode<E> balance(AVLNode<E> n) {
        if(n == null) {
            return n;
        }

        if(height(n.getLeft()) - height(n.getRight()) > ALLOWED_IMBALANCE) {
            if(height(n.getLeft().getLeft())
                    >= height(root.getLeft().getRight())) {
                n = rotateWithLeftChild(n);
            } else {
                n = doubleWithLeftChild(n);
            }
        } else if(height(n.getRight())
                - height(n.getLeft()) > ALLOWED_IMBALANCE) {
            if(height(n.getRight().getRight())
                    >= height(n.getRight().getLeft())) {
                n = rotateWithRightChild(n);
            } else {
                n = doubleWithLeftChild(n);
            }
        }
        n.setHeight(Math.max(height(n.getLeft()),height(n.getRight())) + 1);
        return n;

    }

    /**
     * Rotate binary tree with left child,
     * For case 1, k2.left.left add one.
     * update height, and return new root
     * @param k2
     * @return
     */
    private AVLNode<E> rotateWithLeftChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.getLeft();
        k2.getLeft().setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) +1);
        return k1;
    }

    /**
     * Rotate binary tree with right child
     * Fo2 case 4, k2.right.right add one
     * update height, and return new root
     * @param k2
     * @return
     */
    private AVLNode<E> rotateWithRightChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.getRight();
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);
        k2.setHeight(Math.max(height(k2.getLeft()),
                height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k2), height(k1.getRight())) + 1);
        return k1;
    }

    /**
     * double rotate binary tree node; first left child
     * with its right child; then node k3 with new left child
     * For AVL trees, this is a double rotation for case 2
     * update heights, then return new root
     * @param k3
     * @return
     */
    private AVLNode<E> doubleWithLeftChild(AVLNode<E> k3) {
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    /**
     * double rotate binary tree node; first right child
     * with its left child; then node k3 with new left child
     * For AVL trees, this is a double rotation for case 3
     * update heights, then return new root;
     * @param k3
     * @return
     */
    private AVLNode<E> doubleWithRightChild(AVLNode<E> k3) {
        k3.setLeft(rotateWithLeftChild(k3.getRight()));
        return rotateWithRightChild(k3);
    }

}
