package com.github.caozhi6655.offer;

/**
 * @Description
 * @Author ht
 * @Date 2019/8/1 20:04
 */
public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        int rowSize = array.length;
        int colSize = array[0].length;

        int row = rowSize - 1;
        int col = 0;
        while (row >= 0 && col < colSize) {
            if (array[row][col] > target) {
                row--;
            } else if (array[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
