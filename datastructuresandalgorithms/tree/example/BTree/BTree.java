package datastructuresandalgorithms.tree.example.BTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/20 16:07
 * @description: M-order balance tree has following features
 *               (1) data is on the leaf node
 *               (2) The searching direstion was pointed by M-1 key words on
 *                   non-leaf nodes
 *               (3) The count of Node is between 2 and M whether root or
 *                   leaf nodes;
 *               (4) All of the non-leaf nodes has child node number range from
 *                   M/2 to M, except the root node
 *               (5) All of the leaf node has the same depth, which has between
 *                   L/2 and L items. L is the max count in the leaf
 *               (6) The root node can have two child node at least
 */

public class BTree<E extends Cell> {
    // order of tree, M
    private int order;
    private Page root;
    public BTree(int order) {
        this.order = order;
        root = null;
//        root = new Page(order);
    }

    public Page getRoot() {
        return root;
    }

    public void createRoot() {
        root = new Page(order);
    }

    public void add(E x) {

    }

    public void remove() {}

    public Page merge() {}



}
