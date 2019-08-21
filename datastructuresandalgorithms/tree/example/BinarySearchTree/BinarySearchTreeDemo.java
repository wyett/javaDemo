package datastructuresandalgorithms.tree.example.BinarySearchTree;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/15 20:22
 * @description: TODO
 */

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        // tree 1
        // [H,G,null]
        //[G,F,null]
        //[F,E,null]
        //[E,D,null]
        //[D,C,null]
        //[C,B,null]
        //[B,A,null]
        //[A,null,null]
        BinarySearchTree<String> tree1 = new BinarySearchTree<>();
        String[] str = {"H", "G", "F", "E", "D", "C", "B", "A"};
        for(int i = 0; i < str.length; i++) {
            tree1.insert(str[i]);
        }
        tree1.printTree();


        System.out.println("");

        // tree2
        // [0,null,1]
        //[1,null,2]
        //[2,null,3]
        //[3,null,4]
        //[4,null,5]
        //[5,null,6]
        //[6,null,7]
        //[7,null,8]
        //[8,null,9]
        //[9,null,null]
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
        for(int i = 0; i < 10; i++) {
            tree2.insert(i);
        }
        tree2.printTree();

        System.out.println();

        // tree3
        // [D,A,E]
        //[A,null,C]
        //[C,B,null]
        //[B,null,null]
        //[E,null,H]
        //[H,G,null]
        //[G,F,null]
        //[F,null,null]
        BinarySearchTree<String> tree3 = new BinarySearchTree<>();
        String[] str2 = {"D", "A", "C", "B", "E", "H", "G", "F"};
        for(int i = 0; i < str2.length; i++) {
            tree3.insert(str2[i]);
        }
        tree3.printTree();

        System.out.println();

        // tree4
        // [5,3,8]
        //[3,0,4]
        //[0,null,2]
        //[2,1,null]
        //[1,null,null]
        //[4,null,null]
        //[8,6,9]
        //[6,null,7]
        //[7,null,null]
        //[9,null,null]
        BinarySearchTree<Integer> tree4 = new BinarySearchTree<>();
        Integer[] arr = {5, 3, 4, 0, 2, 1, 8, 6, 9, 7};
        for(int i = 0; i < arr.length; i++) {
            tree4.insert(arr[i]);
        }
        tree4.printTree();
    }
}
