package com.lzl.coll.map;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, "String: " + i);
        }
    }
}
