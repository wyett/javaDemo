package datastructuresandalgorithms.tree.struct.BinaryTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/14 20:22
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
//        BinaryTree<String> tree = new BinaryTree<>();
        BinaryNode<String> n1 = new BinaryNode<String>("A");
        BinaryNode<String> n2 = new BinaryNode<String>("B");
        BinaryNode<String> n3 = new BinaryNode<String>("C");
        BinaryNode<String> n4 = new BinaryNode<String>("D");
        BinaryNode<String> n5 = new BinaryNode<String>("E");
        BinaryNode<String> n6 = new BinaryNode<String>("F", n4, n5);
        BinaryNode<String> n7 = new BinaryNode<String>("G", n3, n2);
        BinaryNode<String> n8 = new BinaryNode<String>("H", n1, null);
        BinaryNode<String> n9 = new BinaryNode<String>("I", n6, n7);
        BinaryNode<String> n10 = new BinaryNode<String>("J", n9, n8);
        BinaryTree<String> tree = new BinaryTree<>();

        tree.setRoot(n10);
        System.out.println(tree.getRoot().data);
//        tree.getHeight(n10);
        tree.find("C");
        tree.printTree(tree.getRoot(), "inorder");
        tree.printTree(tree.getRoot(), "preorder");
        tree.printTree(tree.getRoot(), "postorder");
        tree.printTree(tree.getRoot(), "levelorder");




    }
}
