package lzl.com.cache;

public class Node<K, V>{
    public Node<K, V> prev;
    public Node<K, V> next;
    public int freqNum;
    public K key;
    public V value;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.freqNum = 0;
    }
    public Node(){

    }

    @Override
    public String toString() {
        return "key：" + this.key + "and value ：" + this.value;
    }
}
