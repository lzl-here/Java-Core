package lzl.com.cache;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * 最近最少使用，链表从左到右按照最近访问的时间排序，越左边就是最近访问的，越靠右就是很久之前访问的
 * last recently used
 * 每次访问都放到头，这样链表中越后面的node就是最久被访问的
 */
public class LRUCache<K, V> extends Cache<K, V>{
    /**
     * 双向链表
     */
    private Node<K, V> head = new Node<>();
    private Node<K, V> tail = new Node<>();
    /**
     * map
     */
    private HashMap<K, Node<K, V>> map = new HashMap<>();
    private int capacity;
    private int size;

    public LRUCache(int capacity){
        super(capacity);
        this.init();
    }

    private void init(){
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public V get(K key){
        Node<K, V> node = this.map.get(key);
        if(node != null){
            this.remove(key);
            this.addToHead(node);
            return node.value;
        }
        return null;
    }

    @Override
    public void add(K key, V value){
        if(capacity == 0){
            throw new RuntimeException("capacity 为 0");
        }
        if(this.capacity == this.size){
            this.removeLast();
        }
        this.addToHead(new Node<>(key, value));
    }

    @Override
    public void remove(K key){
        Node<K, V> node = this.map.get(key);
        map.remove(key);
        Node<K, V> next = node.next;
        Node<K, V> prev = node.prev;
        prev.next = next;
        next.prev = prev;
        this.size--;
    }

    private void removeLast(){
        Node<K, V> node = this.tail.prev;
        if(node == head){
            return;
        }
        Node<K, V> prev = node.prev;
        prev.next = this.tail;
        this.tail.prev = prev;
        this.map.remove(node.key);
        this.size--;
    }

    private void addToHead(Node<K, V> node){
        Node<K, V> next = this.head.next;
        node.next = next;
        next.prev = node;
        node.prev = head;
        head.next = node;
        this.map.put(node.key, node);
        this.size++;
    }

    @Override
    public void forEach(Consumer<Node<K, V>> consumer){
        Node<K, V> node = this.head.next;
        while(node != this.tail){
            consumer.accept(node);
            node = node.next;
        }
    }
}
