package com.hunterdev.assignmenttest;

import android.util.Log;

import com.hunterdev.assignmenttest.data.model.Node;

import static android.content.ContentValues.TAG;

/**
 * Created by Thanh Tuan on 4/26/2018.
 */
public class CheckPalindrome {

    CheckPalindrome() {
    }

    public boolean check(Node head){
        if(head == null || head.getNext() == null) return true;

        //Find list center
        Node fast = head;
        Node slow = head;

        while(fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            Log.e(TAG, "check: " + fast.getData() + slow.getData());
        }

        Node secondHead = slow.getNext();
        slow.setNext(null);

        //Reverse second part of the list
        Node p1 = secondHead;
        Node p2 = p1.getNext();
        while(p2 != null){
            Node temp = p2.getNext();
            p2.setNext(p1);
            p1 = p2;
            p2 = temp;
        }
        secondHead.setNext(null);

        //compare two sublists now
        Node p = p1;
        Node q = head;
        while(p!=null){
            if(p.getData() != q.getData())
                return false;
            p = p.getNext();
            q = q.getNext();
        }
        return true;
    }
}
