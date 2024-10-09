package lzl.com.producer;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {

    private static final AtomicInteger count = new AtomicInteger(0);

    private static final Callable<Integer> callable = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return count.getAndIncrement();
        }
    };

    private static final CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) throws Exception {

        Callable[] buffer = new Callable[1024];
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        AtomicInteger elementNumber = new AtomicInteger(0);
        Producer<Integer> producer = new Producer<>(buffer, lock, producerCondition, consumerCondition, elementNumber);
        Consumer<Integer> consumer = new Consumer<>(buffer, lock, producerCondition, consumerCondition, elementNumber);


        produce(100000000, producer);
        consume(100000000, consumer);
        barrier.await();
        System.out.println(count.get());
    }

    private static void produce(int times, Producer producer) {
        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    producer.produce(callable);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
        ).start();
    }

    private static void consume(int times, Consumer consumer) throws Exception {
        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    consumer.consume();
                } catch (Exception e) {
                    throw new RuntimeException(e);
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

    static class Producer<R> {
        private Callable<R>[] buffer;
        private Lock lock;
        private AtomicInteger elementNumber;
        private Condition producerCondition;
        private Condition consumerCondition;

        public Producer(Callable<R>[] buffer, Lock lock, Condition producerCondition, Condition consumerCondition, AtomicInteger elementNumber) {
            this.buffer = buffer;
            this.lock = lock;
            this.producerCondition = producerCondition;
            this.consumerCondition = consumerCondition;
            this.elementNumber = elementNumber;
        }

        public void produce(Callable<R> callable) throws InterruptedException {
            try {
                lock.lock();
                while (elementNumber.get() == buffer.length - 1) {
                    this.producerCondition.await();
                }
                this.buffer[elementNumber.getAndIncrement()] = callable;
                consumerCondition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    static class Consumer<R> {
        private Callable<R>[] buffer;
        private Lock lock;
        private AtomicInteger elementNumber;
        private Condition producerCondition;
        private Condition consumerCondition;

        public Consumer(Callable<R>[] buffer, Lock lock, Condition producerCondition, Condition consumerCondition, AtomicInteger elementNumber) {
            this.buffer = buffer;
            this.lock = lock;
            this.producerCondition = producerCondition;
            this.consumerCondition = consumerCondition;
            this.elementNumber = elementNumber;
        }

        public void consume() throws Exception {
            try{
                lock.lock();
                while (elementNumber.get() == 0) {
                    consumerCondition.await();
                }
                Callable<R> callable = buffer[elementNumber.getAndDecrement() - 1];
                callable.call();
                producerCondition.signalAll();
            }finally {
                lock.unlock();
            }


        }

    }

}
