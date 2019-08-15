package datastructuresandalgorithms.tree.struct.BinaryTree;

import java.util.*;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/14 15:53
 * @description: binary tree
 */

public class BinaryTree<E extends Comparable<? super E>> {
    // root node
    private BinaryNode<E> root;

    /**
     * binary tree constructor
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * constructor
     * @param root
     */
    public BinaryTree(BinaryNode<E> root) {
        this.root = root;
    }

    /**
     * check if empty
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * make tree null
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * return height of root node
     * @return
     */
    public int getHeight() {
        return getHeight(getRoot());
    }

    /**
     * return height of node.data == x
     * @param x
     * @return int
     */
    public int getHeight(E x) {
        return getHeight(getParentNode(x)) - 1;
    }

    /**
     * get height of node cur
     * @param cur
     * @return
     */
    public int getHeight(BinaryNode<E> cur) {
        if(cur == null) {
            return 0;
        }

        if(cur.left == null && cur.right == null) {
            return 1;
        }
        int leftHight = getHeight(cur.left);
        int rightHight = getHeight(cur.right);
        return leftHight > rightHight ? leftHight + 1 : rightHight + 1;
    }

    /**
     * get root Node
     * @return
     */
    public BinaryNode<E> getRoot() {
        return root;
    }

    /**
     * set root node
     * @param root
     */
    public void setRoot(BinaryNode<E> root) {
        this.root = root;
    }

    /**
     * print nodes between t node with method
     * @param methodType contain inorder, preorder, postorder, levelorder
     */
    public void printTree(String methodType) {
        switch (methodType) {
            case "inorder":
                inOrder();
                break;
            case "preorder":
                preOrder();
                break;
            case "postorder":
                postOrder();
                break;
            case "levelorder":
                levelOrder();
                break;
                default:
        }
    }

    /**
     * find if it has node.data = x in the whole tree
     * @param x
     * @return
     */
    public boolean find(E x) {
        return find(x, root);
    }

    /**
     * find if t node and its child nodes has data x, return true;
     * else, return false
     * @param x value of node
     * @param t the begining node
     * @return
     */
    private boolean find(E x, BinaryNode<E> t) {
        if(t == null) {
            throw new NoSuchElementException();
        }

        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.offer(t);
        while(!queue.isEmpty()) {
            BinaryNode<E> cur = queue.poll();
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
            if (x.compareTo(cur.data) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * When cur is null, return null; else return node.data;
     * The best coding is add this func into BinaryNode.java, each field
     * should be private, and can only be called by set() or get(). But these
     * costs a lot, so the later data struct will be better, and for
     * BinaryTree, just keep it.
     * @param cur
     * @return
     */
    public E getData(BinaryNode<E> cur) {
        if(cur == null) {
            return null;
        }
        return cur.data;
    }

    /**
     * get current node's parent node when node.data == x
     * @param x
     * @return
     */
    public BinaryNode<E> getParentNode(E x) {
        if(isEmpty()) {
            return null;
        }

        // root node has no parent node
        if(x.compareTo(root.data) == 0) {
            return null;
        }

        Stack<BinaryNode<E>> stack = new Stack<>();
        BinaryNode<E> curNode = root;

        while(!stack.isEmpty() || curNode != null) {
            if(curNode != null) {
                if((curNode.left != null
                        && x.compareTo(curNode.left.data) == 0) ||
                        (curNode.right != null
                                && x.compareTo(curNode.right.data) == 0)) {
                    return curNode;
                }
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop().right;
            }
        }
        return null;
    }

    public BinaryNode<E> getLChild(E x) {
        if(isEmpty()) {
            return null;
        }

        Queue<BinaryNode<E>> queue = new LinkedList<>();
        BinaryNode<E> curNode = null;
        queue.offer(root);
        while(!queue.isEmpty()) {
            curNode = queue.poll();
            if(curNode.left != null) {
                queue.offer(curNode.left);
            }
            if(curNode.right != null) {
                queue.offer(curNode.right);
            }
            if(x.compareTo(curNode.data) == 0) {
                return curNode.left;
            }
        }
        return null;
    }

    public BinaryNode<E> getRChild(E x) {
        if(isEmpty()) {
            return null;
        }

        Queue<BinaryNode<E>> queue = new LinkedList<>();
        BinaryNode<E> curNode = null;
        queue.offer(root);
        while(!queue.isEmpty()) {
            curNode = queue.remove();
            if(curNode.left != null) {
                queue.offer(curNode.left);
            }
            if(curNode.right != null) {
                queue.offer(curNode.right);
            }
            if(x.compareTo(curNode.data) == 0) {
                return curNode.right;
            }
        }
        return null;
    }

    /**
     * inorder traversal
     * leftChild - parentsNode - rightNode
     * @param cur
     */
    public void inOrder(BinaryNode<E> cur) {
        if(cur != null) {
            inOrder(cur.left);
            System.out.print(cur.data);
            inOrder(cur.right);
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    /**
     * preorder traversal
     * parentsNode - leftChild - rightChild
     * @param cur
     */
    public void preOrder(BinaryNode<E> cur) {
        if(cur != null) {
            System.out.print(cur.data);
            preOrder(cur.left);
            preOrder(cur.right);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    /**
     * postorder traversal
     * leftChild - rightCild - parentsNode
     * @param cur
     */
    private void postOrder(BinaryNode<E> cur) {
        if(cur!= null) {
            postOrder(cur.left);
            postOrder(cur.right);
            System.out.print(cur.data);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }


    /**
     * levelorder traversal
     * @param cur
     * @return list of node.data
     */
    public List<E> levelOrder(BinaryNode<E> cur) {
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        List<E> list = new ArrayList<>();
        queue.offer(cur);
        BinaryNode<E> tmpNode = null;
        while(!queue.isEmpty()) {
            tmpNode = queue.poll();
            list.add(tmpNode.data);
            if(tmpNode.left != null) {
                queue.offer(tmpNode.left);
            }
            if(tmpNode.right != null) {
                queue.offer(tmpNode.right);
            }
        }
        return list;
    }

    public void levelOrder() {
        for(E b: levelOrder(root)) {
            System.out.print(b);
        }
        System.out.println();
    }
}


