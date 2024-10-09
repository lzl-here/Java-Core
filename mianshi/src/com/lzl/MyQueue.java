package com.lzl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue {
    private Object[] items;
    private int capacity;
    private int size;
    private Lock lock;

    public MyQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.items = new Object[capacity];
        this.lock = new ReentrantLock();
    }


}
