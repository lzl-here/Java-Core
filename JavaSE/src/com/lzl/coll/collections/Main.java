package com.lzl.coll.collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(9999999 + 10);
        List<Integer> linkedList = new LinkedList<>();

        add(arrayList);
        add(linkedList);

        remove(arrayList); // 数组每次remove都需要移动后面的元素，假如remove的元素很靠前，那么需要移动整个数组，很耗时间
        remove(linkedList);// 链表直接remove，只需要找到这个元素，remove的操作是O(1)，性能很好

        forEach(arrayList); // 缓存局部性原理
        forEach(linkedList); // 寻址
    }



    private static void add(List<Integer> list) {
        for (int i = 0; i < 9999999; i++) {
            list.add(i);
        }
    }



    private static void remove(List<?> list) {
        int l = 0, end = list.size() / 2000;
        for (int i = l; i < end; i++) {
            list.remove(i);
        }
    }

    private static void forEach(List<?> list){
        for (Object o : list){
            // do nothing
        }
    }
}
