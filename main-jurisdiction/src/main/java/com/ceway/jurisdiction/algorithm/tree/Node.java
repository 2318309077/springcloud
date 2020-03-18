package com.ceway.jurisdiction.algorithm.tree;

public class Node<T>{
    int key;
    T val;
    Node<T> left;
    Node<T> right;

    public Node(int key, T val) {
        this.key = key;
        this.val = val;
    }
}
