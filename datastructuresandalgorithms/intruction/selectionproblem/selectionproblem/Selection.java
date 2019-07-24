package datastructuresandalgorithms.intruction.selectionproblem.selectionproblem;

/**
 * @author : chelei
 * @date : Created in 2019/7/15 14:40
 * @description: Find the k element in set of n elements, and k=N/2
 * @modified By:
 * @version: $
 */

public class Selection {
    private static int[] arr;
    public Selection(int[] arr){
        this.arr = arr;
    }
    public int[] dubbleSort() {
        /**
         * description: dubble sort
         * @param  * @Param: arr
         * @return int[]
         */
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public int getMidValue() {
        int[] tmpArray = dubbleSort();
        return tmpArray[tmpArray.length/2];
    }
    public long getRuntime() {
        long startTime = System.nanoTime();
        getMidValue();
        long endTime = System.nanoTime();
        long runTime = (endTime - startTime);
        return runTime;
    }
    public String toString() {
        return getMidValue() + ": " + getRuntime();
    }
}
