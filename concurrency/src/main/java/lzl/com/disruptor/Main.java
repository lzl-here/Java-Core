package lzl.com.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class Main {

    private static final ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(500);
    private static final LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(500);

    private static final ThreadFactory threadFactory = r -> new Thread(r, "simpleThread");
    private static final EventFactory<Element> factory = Element::new;
    public static final EventHandler<Element> handler = (element, sequence, endOfBatch) -> System.out.println("Element: " + element.get());
    public static final BlockingWaitStrategy strategy = new BlockingWaitStrategy();

    public static final Disruptor<Element> disruptor = new Disruptor(factory, 16, threadFactory, ProducerType.SINGLE, strategy);

    public static void main(String[] args) throws Exception {
        disruptorBench(1000);
    }


    private static void disruptorBench(int times) throws InterruptedException {
        disruptor.handleEventsWith(handler);
        disruptor.start();
        RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();
        for (int i = 0; i < times ; i++) {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try {
                // 返回可用位置的元素
                Element event = ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.set(i);
            } finally {
                ringBuffer.publish(sequence);
            }
            Thread.sleep(10);
        }
    }

    private static void arrayBlockingQueueBench(int times){

    }
}
