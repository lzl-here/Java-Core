package lzl.com.tree;

import lombok.Data;

@Data
public class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    boolean isLeaf = false;
}
