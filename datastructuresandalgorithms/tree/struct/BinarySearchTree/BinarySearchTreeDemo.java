package datastructuresandalgorithms.tree.struct.BinarySearchTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/15 20:22
 * @description: TODO
 */

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
//        BinarySearchTree<String> tree = new BinarySearchTree<>();
//        String[] str = {"A", "B", "C", "D", "E", "F", "G", "H"};
//        for(int i = 0; i < str.length; i++) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        for(int i = 0; i < str.length; i++)
//            System.out.println(str[i]);
//            tree.insert(str[i]);
//        }
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
            tree.insert(i);
//            System.out.println(tree.contains(i));
        }
//        System.out.println(tree.getRoot().getData());
        tree.printTree();
    }
}
