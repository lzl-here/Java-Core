package com.lzl.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        add(arrayList);
        add(linkedList);

        remove(arrayList);
        remove(linkedList);
    }

    private static void add(List<Integer> list) {
        for (int i = 0; i < 9999999; i++) {
            list.add(i);
        }
    }

    private static void remove(List<Integer> list) {
        Random random = new Random(list.size());
        for (int i = 0; i < 9999; i++) {
            int index = random.nextInt(list.size());
            list.remove(index);
        }
    }
}
