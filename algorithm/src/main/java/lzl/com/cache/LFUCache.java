package lzl.com.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少未被使用
 * TODO：忘记记录tail节点了
 */
public class LFUCache<K, V> extends Cache<K, V>{
    private Integer minFreq;
    /**
     * 频率map，key是频率，value是对应的链表
     */
    Map<Integer, Node<K, V>> freqMap = new HashMap<>();
    Map<K, Node<K, V>> nodeMap = new HashMap<>();

    public LFUCache(int capacity){
        super(capacity);
    }


    @Override
    public V get(K key) {
        if(!nodeMap.containsKey(key)){
            return null;
        }
        Node<K, V> node = this.nodeMap.get(key);
        Integer freqNum = node.freqNum;
        freqNum++;
        Node<K, V> head;
        if(!freqMap.containsKey(freqNum)){
            head = this.createList();
            this.freqMap.put(freqNum, head);
        }else{
            head = this.freqMap.get(freqNum);
        }
        this.clearFromFreqMap(node);
        this.addToFreqHead(node, head);
        return node.value;
    }

    private void clearFromFreqMap(Node<K, V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @Override
    public void remove(K key) {
        if(!nodeMap.containsKey(key)){
            return;
        }
        Node<K, V> node = nodeMap.get(key);
        nodeMap.remove(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        Node<K, V> freqHead = this.freqMap.get(node.freqNum);
        if(this.listIsEmpty(freqHead)){
            this.freqMap.remove(node.freqNum);
        }
        this.size--;
    }

    @Override
    public void add(K key, V value) {
        if(this.size == this.capacity){
            this.removeLast();
        }
        Node<K, V> head;
        if(this.freqMap.get(0) == null){
            head = this.createList();
            this.freqMap.put(0, head);
        }else{
            head = this.freqMap.get(0);
        }
        this.addToFreqHead(new Node<>(key, value), head);
        size++;
    }

    private void removeLast(){
        Node<K, V> head = this.freqMap.get(this.minFreq);
    }

    private boolean listIsEmpty(Node<K, V> head){
        return head.next.next == null;
    }

    private Node<K, V> createList(){
        Node<K, V> head = new Node<>();
        Node<K, V> tail = new Node<>();
        head.next = tail;
        tail.prev = head;
        return head;
    }

    private void addToFreqHead(Node<K, V> node, Node<K, V> head){
        Node<K, V> next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
}
