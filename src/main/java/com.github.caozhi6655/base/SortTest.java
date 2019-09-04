package com.github.caozhi6655.base;

/**
 * @Description
 * @Author ht
 * @Date 2019/7/31 23:39
 */
public class SortTest {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,20,8,2,1,7,9,4,6,21,55,0};
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

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int par = partition(array, begin, end);
        quickSort(array, begin, par - 1);
        quickSort(array, par + 1, end);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = right;
        while (left < right) {
            while (array[left] < array[pivot]) left++;
            while (array[right] >= array[pivot] && right > left) right--;
            swap(array, left, right);
        }
        swap(array, left, pivot);
        return left;
    }

    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSort(array, tmp, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, tmp, left, mid);
        mergeSort(array, tmp, mid + 1, right);
        merge(array, tmp, left, mid , right);
    }

    public static void merge(int[] array, int[] tmp, int left, int mid, int right) {
        int leftBegin = left;
        int leftEnd = mid;
        int rightBegin = mid + 1;
        int rightEnd = right;
        int n = 0;
        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
            if (array[leftBegin] < array[rightBegin]) {
                tmp[n++] = array[leftBegin++];
            } else {
                tmp[n++] = array[rightBegin++];
            }
        }
        while (leftBegin <= leftEnd) {
            tmp[n++] = array[leftBegin++];
        }
        while (rightBegin <= rightEnd) {
            tmp[n++] = array[rightBegin++];
        }
        for (int i = 0; i < n; i++) {
            array[left + i] = tmp[i];
        }
    }

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
