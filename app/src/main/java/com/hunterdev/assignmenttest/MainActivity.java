package com.hunterdev.assignmenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hunterdev.assignmenttest.data.model.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int listData[] = { 1, 2, 3, 2, 1};

        LinkedList linkedList = new LinkedList();

        for (int i : listData) {
            linkedList.insertAtEnd(i);
        }

        CheckPalindrome checkPalindrome = new CheckPalindrome();
        Log.e(TAG, "Check Palindrome: " + checkPalindrome.check(linkedList.getStart()));

        int arr[] = {3, 4, 5, 4, 5, 6, 7, 8, 9, 10, 9, 10, 11};
        FindIndex findIndex = new FindIndex();
        Log.e(TAG, "onCreate: " + findIndex.find(arr,11));
    }
}
