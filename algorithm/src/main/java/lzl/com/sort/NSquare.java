package lzl.com.sort;

import static lzl.com.sort.Utils.confirm;

public class NSquare {
    public static void main(String[] args) {
        confirm(100, 100, 100,Merge::mergeSort);
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int maxPos = 0;
        int maxNum = arr[0];
        int length = arr.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length - i; ++j) {
                if (maxNum < arr[j]) {
                    maxNum = arr[j];
                    maxPos = j;
                }
            }
            // 每轮找出最大的数，放到数组末尾
            int temp = arr[length - 1 - i];
            arr[length - 1 - i] = arr[maxPos];
            arr[maxPos] = temp;
            maxNum = arr[0];
            maxPos = 0;
        }
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 1; j < length - i; ++j) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int length = arr.length;
        if (arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        for (int i = 2; i < length; ++i) {
            int j = i;
            while (j - 1 >= 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

}