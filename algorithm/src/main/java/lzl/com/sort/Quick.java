package lzl.com.sort;

import static lzl.com.sort.Utils.checkArray;
import static lzl.com.sort.Utils.swap;

public class Quick {
    public static void main(String[] args) {
        checkArray(100, 100, System.out::println);
    }

    public static void quickSort(int[] arr){
        doQuickSort(arr, 0, arr.length - 1);
    }
    /**
     * 快速排序
     */
    private static void doQuickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int num = arr[l + (r - l) / 2];
        int pl = l - 1, pr = r + 1;
        while(pl < pr){
            while (arr[++pl] < num);
            while (arr[--pr] > num);
            if(pl < pr){
                swap(arr, pl, pr);
            }
        }
        doQuickSort(arr, l, pr);
        doQuickSort(arr, pr + 1, r);
    }

    static public int findK(int[] _nums, int k) {
        int n = _nums.length;
        return quickSelect(_nums, 0, n - 1, n - k);
    }

    static int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                swap(nums, i, j);
            }
        }
        if (k <= j) return quickSelect(nums, l, j, k);
        else return quickSelect(nums, j + 1, r, k);
    }



}
