package com.hunterdev.assignmenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hunterdev.assignmenttest.data.model.LinkedList;
import com.hunterdev.assignmenttest.data.model.Node;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList linkedList = new LinkedList();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);

        CheckPalindrome checkPalindrome = new CheckPalindrome();
        Log.e(TAG, "Check Palindrome: " + checkPalindrome.check(linkedList.getStart()));
    }
}
