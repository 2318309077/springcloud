package com.ceway.jurisdiction.algorithm;

public class LinkNode<T> {
    T value;
    T first;
    T taill;

    LinkNode(T value){
        this.taill =null;
        this.first =null;
        this.value = value;
    }
}
