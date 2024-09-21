package lzl.com.lock;

import lzl.com.utils.Utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Utils.loopPrint(100);
//        atomicIncr(0, 10000000, 60); // 29700
//        syncIncr(0, 10000000, 60);// 31084
//        lockIncr(0, 10000000, 60, lock); // 13617
    }


    private static void atomicIncr(int start, int end, int threadNums) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(threadNums + 1);
        AtomicInteger integer = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNums; ++i) {
            new Thread(() -> {
                for (int j = start; j < end; ++j) {
                    integer.incrementAndGet();
                }
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        barrier.await();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("atomicIncr执行完毕，结果为%d, 耗时：%d", integer.get(), (endTime - startTime)));
    }

    private static int count = 0;

    private static void syncIncr(int start, int end, int threadNums) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(threadNums + 1);
        Object lock = new Object();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNums; ++i) {
            new Thread(() -> {
                for (int j = start; j < end; ++j) {
                    synchronized (lock) {
                        count++;
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        barrier.await();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("syncIncr执行完毕，结果为 %d,耗时：%d", count, (endTime - startTime)));
    }

    private static void lockIncr(int start, int end, int threadNums, Lock lock) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(threadNums + 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNums; ++i) {
            new Thread(() -> {
                for (int j = start; j < end; ++j) {
                    lock.lock();
                    count++;
                    lock.unlock();
                }
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        barrier.await();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("lockIncr执行完毕，结果为 %d,耗时：%d", count, (endTime - startTime)));
    }

}
