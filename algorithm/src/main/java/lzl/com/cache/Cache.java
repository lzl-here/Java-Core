package lzl.com.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class Cache<K, V> {

    protected Map<K, Node<K, V>> nodeMap = new HashMap<>();
    protected int capacity;
    protected int size;

    public Cache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.nodeMap = new HashMap<>();
    }

    /**
     * 根据key获取value
     */
    abstract V get(K key);

    /**
     * 移除key对应的元素
     */
    abstract void remove(K key);

    /**
     * 添加key-value
     */
    abstract void add(K key, V value);

    /**
     * 遍历cache
     */
    void forEach(Consumer<Node<K, V>> consumer) {
        this.nodeMap.forEach((k, v) -> {
            consumer.accept(v);
        });
    }
}
