package com.ceway.jurisdiction.algorithm;

/**
 * 双向链表
 */
public class TwoWayLinkedList<T> {
    LinkNode head; //头节点
    LinkNode rear; //尾节点
    void  clear(){
        head = null;
        rear = null;
    }

    /**
     * 从当前节点前面加数据
     * @param data
     */
    public  void  insertHead(T data){
        LinkNode node = new LinkNode(data);
        if(head == null){
            rear = node;
        }else{
            head.first = node;
            node.taill = head;
        }
        head = node;
    }
    /**
     * 从当前节点后面加数据
     * @param data
     */
    public  void  insertRear(T data){
        LinkNode node = new LinkNode(data);
        if(head == null){
            head = node;
        }else{
            rear.taill = node;
            node.first = rear;
        }
        rear = node;
    }
}

