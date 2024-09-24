package lzl.com.sort;

import java.util.Arrays;
import java.util.function.Consumer;

public class Utils {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void forEach(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void forEach(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static ListNode buildList(int[] array) {
        ListNode virtualHead = new ListNode();
        ListNode node = virtualHead;
        for (int j : array) {
            node.next = new ListNode(j);
            node = node.next;
        }
        return virtualHead.next;
    }

    /**
     * 对数器
     */
    public static void confirm(int times, int len, int maxNum, Consumer<int[]> sort) {
        for (int i = 0; i < times; ++i) {
            int[] array = generateArray(len, maxNum);
            int[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(array);
            sort.accept(copy);

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
     * 简单检验
     */
    public static void checkArray(int len, int maxNum, Consumer<int[]> sort) {
        int[] array = generateArray(100, 100);
        sort.accept(array);
        printArray(array);
    }

    /**
     * 生成随机数组
     */
    public static int[] generateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(",");
            }
        }
    }


}
