package com.github.caozhi6655;

import java.util.*;

/**
 * @Description
 * @Author ht
 * @Date 2019/7/31 23:36
 */
public class Main {
    public static void main(String[] args) {


        Main main = new Main();

        int[] a = {2,3,4,2,6,2,5,1};
        main.maxInWindows(a, 3);
    }


    static public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Collections.reverse(list);

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (num == null || num.length == 0 || size == 0 || num.length < size) return result;
        int max = -1;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, num[i]);
        }
        result.add(max);
        for(int i = 1; i <= num.length - size; i++) {
            if (num[i - 1] < num[i - 1 + size] || num[i - 1] == max) {
                int max2 = num[i];
                for (int j = i; j < i + size; j++) {
                    max2 = Math.max(max2, num[j]);
                }
                result.add(max2);
                max = max2;
            } else {
                result.add(max);
            }
        }
        return result;
    }

}
