package com.wyett.datastructuresandalgorithms.intruction.selectionproblem.selectionproblem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/15 15:43
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class SelectionTest {
    @Test
    public static void main(String[] args) {
        print("Input number seperated by comma:");
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toString();
        String[] arr = str.split(",");
        int[] tmpArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tmpArray[i] = Integer.parseInt(arr[i]);
        print(Arrays.toString(tmpArray));
        System.out.println(new Selection(tmpArray));
    }
}
