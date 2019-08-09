package datastructuresandalgorithms.list.practice;

import org.junit.jupiter.api.Test;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/9 15:47
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class SinglyLinkedListStackTest {
//    @org.junit.jupiter.api.Test
    public static void main(String[] args) {
        Ex31_SingleLinkedListStack<String> ess =
                new Ex31_SingleLinkedListStack<>(new SinglyListWithnotEnd<>());
        ess.push("aa");
        ess.push("bb");
        ess.push("cc");
        ess.push("dd");
        int count = ess.size();
        while(count-- > 0) {
            System.out.println(ess.pop());
        }
    }
}
