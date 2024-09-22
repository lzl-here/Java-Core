package lzl.com.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer<R> {
    private final BlockingQueue<? extends Callable<R>> queue;

    public Consumer(BlockingQueue<? extends Callable<R>> queue) {
        this.queue = queue;
    }

    public void consume(java.util.function.Consumer<R> consumer) throws Exception {
        Callable<R> callable = queue.poll();
        if (callable != null) {
            consumer.accept(callable.call());
        }
    }
}
