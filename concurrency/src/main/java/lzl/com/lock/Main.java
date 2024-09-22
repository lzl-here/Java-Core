package lzl.com.lock;

import lzl.com.utils.Utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * redisson tryAcquire：
 * return commandExecutor.syncedEval(getRawName(), LongCodec.INSTANCE, command,
 * "if ((redis.call('exists', KEYS[1]) == 0) " +
 * "or (redis.call('hexists', KEYS[1], ARGV[2]) == 1)) then " +
 * "redis.call('hincrby', KEYS[1], ARGV[2], 1); " +
 * "redis.call('pexpire', KEYS[1], ARGV[1]); " +
 * "return nil; " +
 * "end; " +
 * "return redis.call('pttl', KEYS[1]);",
 * <p>
 * <p>
 * <p>
 * KEYS[1]是锁的key，ARGS[1]是过期时间，ARGV[2]是线程的id
 * <p>
 * 检查Redis中是否有这个key，如果不存在抢锁成功
 * 或者锁的key是哈希表，则判断哈希表里是否有自己线程id，这个字段里面存的是重入次数，如果这个字段非空也抢锁成功
 * 抢锁成功设置超时时间，以及重入线程id的重入次数++
 * <p>
 * 这里的返回值是ttl（过期时间）
 * 抢锁成功返回null
 * 抢锁失败返回ttl，用于告诉抢锁线程还要等多久
 */

public class Main {

    private static final ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Utils.loopPrint(100);
//        atomicIncr(0, 10000, 20); // 3
//        syncIncr(0, 1000, 10);// 3
        lockIncr(0, 10000, 20, reentrantLock); // 9735
//        lockIncr(0, 10000, 20, RedisLock.rLock); // 24160
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
        System.out.printf("atomicIncr执行完毕，结果为%d, 耗时：%d%n", integer.get(), (endTime - startTime));
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
        System.out.printf("syncIncr执行完毕，结果为 %d,耗时：%d%n", count, (endTime - startTime));
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
        System.out.printf("lockIncr执行完毕，结果为 %d,耗时：%d%n", count, (endTime - startTime));
    }

}
