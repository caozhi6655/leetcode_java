package com.github.caozhi6655.offer;

/**
 * @Description
 * @Author ht
 * @Date 2019/8/3 14:55
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0]; //
        int allMax = array[0]; //
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]); // 包含array[i]的最大值
            allMax = Math.max(max, allMax); // 所有子数组的最大值
        }
        return allMax;
    }

    public static int f(int[] array) {
        int max = 1;
        int maxAll = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                max += 1;
            } else {
                max = 1;
            }
            maxAll = Math.max(max, maxAll);
        }
        return maxAll;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,5,3,4,6,9,7,8};
        System.out.println(f(a));
    }
}
