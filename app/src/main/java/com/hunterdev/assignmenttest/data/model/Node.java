package com.hunterdev.assignmenttest.data.model;

/**
 * Created by Thanh Tuan on 4/26/2018.
 */
public class Node {
    private int data;
    private Node next;

    public Node() {
        next = null;
        data = 0;
    }

    public Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
