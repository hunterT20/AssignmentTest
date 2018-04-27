package com.hunterdev.assignmenttest;

import static java.lang.Math.abs;

public class FindIndex {

    FindIndex() {
    }

    public int find(int arr[], int number){
        int index = 0;
        int size = arr.length;

        while(index < size){
            if(arr[index] == number){
                return index;
            }

            index += abs(number - arr[index]);
        }

        return -1;
    }
}
