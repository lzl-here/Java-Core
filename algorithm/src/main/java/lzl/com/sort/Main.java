package lzl.com.sort;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        confirm(100, 100, 100, Main::insertSort);
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

    /**
     * 快速排序
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (arr.length <= 1) {
            return;
        }
        doSwap(arr, l, r, r);
        int mid = l + (r - l) / 2;
        quickSort(arr, l, mid);
        quickSort(arr, mid + 1, r);
    }

    private static void doSwap(int[] arr, int l, int r, int pos) {
        if (l == r) {
            return;
        }

    }


    /**
     * 对数器
     */
    private static void confirm(int times, int len, int maxNum, Consumer<int[]> consumer) {
        for (int i = 0; i < times; ++i) {
            int[] array = generateArray(len, maxNum);
            int[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(array);
            consumer.accept(copy);
            for (int j = 0; j < array.length; j++) {
                if (array[i] != copy[i]) {
                    System.out.println("error");
                    printArray(copy);
                    return;
                }
            }
        }
    }

    /**
     * 生成随机数组
     */
    private static int[] generateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    /**
     * 打印数组
     */
    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }


}
