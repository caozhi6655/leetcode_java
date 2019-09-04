package com.github.caozhi6655.offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @Description
 * @Author ht
 * @Date 2019/8/1 19:26
 */
public class 数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0){
            return;
        }

        int tmp = 0;
        for (int i : array) {
            tmp ^= i;
        }

        int index1 = 0;
        while ((tmp & 1) != 1) {
            tmp = tmp >> 1;
            index1++;
        }

        for (int i : array) {
            if ((1 & (i >> index1)) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}
