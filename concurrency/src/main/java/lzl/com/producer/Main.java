package lzl.com.producer;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final AtomicInteger count = new AtomicInteger(0);


    private static final BlockingQueue<Callable<Integer>> queue = new ArrayBlockingQueue<>(200);
    private static final Producer<Integer> producer = new Producer<>(queue);
    private static final Consumer<Integer> consumer = new Consumer<>(queue);
    private static final CyclicBarrier barrier = new CyclicBarrier(3);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        // TODO：哪里死锁了？
        runConsumerThread(1000);
        runProducerThread(1000);
        barrier.await();

        System.out.println("结果是：" + count.get());
    }


    private static void runProducerThread(int runTimes) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                for (int i = 0; i < runTimes; i++) {
                    producer.produce(count::incrementAndGet);
                }
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static void runConsumerThread(int runTimes) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                for (int i = 0; i < runTimes; i++) {
                    consumer.consume(System.out::println);
                }
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


}
