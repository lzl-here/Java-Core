package lzl.com.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Producer<R> {

    private final BlockingQueue<Callable<R>> queue;

    public Producer(BlockingQueue<Callable<R>> queue){
        this.queue = queue;
    }

    public void produce(Callable<R> callable) throws Exception{
        queue.put(callable);
    }

}
