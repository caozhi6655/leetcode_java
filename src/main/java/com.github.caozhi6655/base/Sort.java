package com.github.caozhi6655.base;

/**
 * @Description
 * @Author ht
 * @Date 2019/7/31 23:39
 */
public class Sort {


    public static void main(String[] args) {
        int[] array = new int[]{3,5,20,8,2,1,7,9,4,6};
        heapSort(array);
        printArray(array);
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int out = array.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[out]) {
                    swap(array, in, out);
                }
            }
        }
    }

    public static void selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    public static void insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j - 1, j);
                j--;
            }
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(array, left, right);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = right;
        while (left < right) {
            while (array[left] < array[pivot]) {
                left++;
            }
            while (right > left && array[right] >= array[pivot]) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
            }
        }
        swap(array, left, pivot);
        return left;
    }

    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1, tmp);
    }

    public static void mergeSort(int[] array, int left, int right, int[]tmp) {
        if (right - left == 0) {
            return;
        }

        int mid = (right + left) / 2;
        mergeSort(array, left, mid, tmp);
        mergeSort(array, mid + 1, right, tmp);
        merge(array, left, mid, right, tmp);
    }

    public static void merge(int[] array, int left, int mid, int right, int[] tmp) {
        int leftStart = left;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = right;

        int m = 0;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (array[leftStart] < array[rightStart]) {
                tmp[m++] = array[leftStart++];
            } else {
                tmp[m++] = array[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            tmp[m++] = array[leftStart++];
        }

        while (rightStart <= rightEnd) {
            tmp[m++] = array[rightStart++];
        }

        for (int i = 0; i < m; i++) {
            array[i + left] = tmp[i];
        }
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array) {
        int right = array.length - 1;
        for (int i = (right - 1) / 2; i >= 0; i--) {
            heapfy(array, i, right);
        }
        while (right > 0) {
            swap(array, 0, right);
            heapfy(array, 0, right - 1);
            right--;
        }
    }

    public static void heapfy(int[] array, int parent, int board) {
        while (parent < board) {
            int max = parent;
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            if (left <= board && array[max] < array[left]) {
                max = left;
            }
            if (right <= board && array[max] < array[right]) {
                max = right;
            }
            if (max == parent) {
                break;
            } else {
                swap(array, parent, max);
                parent = max;
            }
        }
    }
}
