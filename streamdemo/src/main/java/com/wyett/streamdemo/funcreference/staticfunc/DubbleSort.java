package com.wyett.streamdemo.funcreference.staticfunc;

import java.util.ArrayList;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/23 11:44
 * @description: TODO
 */

public class DubbleSort {
    public static Integer[] dubbleSort(Integer[] ai) {
        for(int i = 0; i < ai.length; i++) {
            int item = 0;
            for(int j = i; j < ai.length; j++) {
                if(ai[i] > ai[j]) {
                    item = ai[j];
                    ai[j] = ai[i];
                    ai[i] = item;
                }
            }
        }

        return ai;
    }
}
