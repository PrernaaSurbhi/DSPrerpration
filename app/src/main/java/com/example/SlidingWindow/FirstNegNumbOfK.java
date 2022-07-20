package com.example.SlidingWindow;
//print first negative number of window size 3.
//Output : -8 0 -6 -6

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegNumbOfK {
    public static void main(String[] args) {
        int[] ar = {5, -2, 3, 4, -5};
        int k = 2;
        getFirstNegNum(ar, k);
    }

    public static void getFirstNegNum(int[] arr, int k) {
        int n = arr.length;
        // create a deque q
        Deque<Integer> q = new LinkedList<>();
        // traverse the first window
        for (int i = 0; i < k; i++) {
            // if the current element is negative add it to the end of deque
            if (arr[i] < 0)
                q.addLast(i);
        }
        // if deque is not empty, front of deque is the index of first negative element
        // else there is no negative element in this window
        if (!q.isEmpty())
            System.out.print(arr[q.peek()] + " ");
        else
            System.out.print("0 ");
        for (int i = k; i < n; i++) {
            // remove previous window elements
            while (!q.isEmpty() && q.peek() <= (i - k)) {
                q.removeFirst();
            }
            // if the current element is negative, add it to the deque
            if (arr[i] < 0)
                q.addLast(i);
            // if deque is not empty, front of deque is the index of first negative element
            // else there is no negative element in this window
            if (!q.isEmpty())
                System.out.print(arr[q.peek()] + " ");
            else
                System.out.print("0 ");
        }
        System.out.println();
    }
}
