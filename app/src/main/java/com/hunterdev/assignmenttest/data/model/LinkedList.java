package com.hunterdev.assignmenttest.data.model;

/**
 * Created by Thanh Tuan on 4/26/2018.
 */
public class LinkedList {
    private Node start;
    private Node end;

    public LinkedList() {
        this.start = null;
        this.end = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data, null);
        if (start == null) {
            start = node;
            end = start;
        } else {
            end.setNext(node);
            end = node;
        }
    }
}
