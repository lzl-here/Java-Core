package lzl.com.producer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Main {

    private static final ArrayBlockingQueue<Callable> taskArrayQueue = new ArrayBlockingQueue<>(1000);
    private static final LinkedBlockingQueue<Callable> taskLinkedQueue = new LinkedBlockingQueue<>(1000);
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final Callable<Integer> task = () -> {
        Thread.sleep(50);
        int num = count.incrementAndGet();
//        System.out.println(num);
        return num;
    };

    private static final int threadNum = 30;
    private static final CyclicBarrier barrier = new CyclicBarrier(2 * threadNum + 1);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        produce(10000000, taskArrayQueue);
        consume(10000000, taskArrayQueue);
        barrier.await();
    }

    private static void produce(int times, BlockingQueue<Callable> queue){
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    queue.offer(task);
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
    private static void consume(int times, BlockingQueue<Callable> queue){
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    try {
                        Callable take = queue.take();
                        take.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
