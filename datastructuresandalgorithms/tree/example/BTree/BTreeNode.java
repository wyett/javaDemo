package datastructuresandalgorithms.tree.example.BTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/21 18:08
 * @description: TODO
 */

public class BTreeNode {
    // index of node
    public long key;
    // if this node is deleted
    public byte delBit;
    // parent of the first node in linkedlist, other's are null
    public BTreeNode parent;
    // child node, leaf nodes child pointed to null
    public BTreeNode child;
    // data of leaf;
    public Cell data;

    // non-leaf node
    public BTreeNode(long key, byte delBit, BTreeNode p, BTreeNode c) {
        this.key = key;
        this.delBit = delBit;
        this.parent = p;
        this.child = c;
    }

    // leaf node
    public BTreeNode(long key, byte delBit, BTreeNode p,  Cell d) {
        this.key = key;
        this.delBit = delBit;
        this.parent = p;
        this.data = d;
    }

    public void setDelBit() {
        this.delBit = (byte)1;
    }

    public byte getDelBit() {
        return this.delBit;
    }
}
