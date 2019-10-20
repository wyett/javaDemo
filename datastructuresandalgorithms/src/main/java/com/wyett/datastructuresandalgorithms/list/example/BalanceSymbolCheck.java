package com.wyett.datastructuresandalgorithms.list.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/1 10:21
 * @description: check if input String is balance
 */

public class BalanceSymbolCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            List<Character> input =
                    new ArrayList<Character>(Arrays.asList(
                            in.nextLine().chars()
                                    .mapToObj(c -> (char) c)
                                    .toArray(Character[]::new)));
            System.out.println(checkBalanceSymbol(input));
        }
    }

    public static boolean checkBalanceSymbol(List<Character> mc) {
        MyStack<Character> msc = new MyStack<>();

        /** init left symbol list */
        List<Character> leftSymbol =
                new ArrayList<Character>(Arrays.asList('(', '[', '{'));

        /** init right symbol list */
        List<Character> rightSymbol =
                new ArrayList<Character>(Arrays.asList(')', ']', '}'));

        for (Character c : mc) {
            if (leftSymbol.contains(c)) {
                msc.push(c);
            } else if (rightSymbol.contains(c)
                    && leftSymbol.indexOf(msc.top()) == rightSymbol.indexOf(c)) {
                msc.pop();
            }
        }

        if (msc.size() == 0) {
            return true;
        }
        return false;
    }
}
