package com.example.SlidingWindow;

//find the max  sum of subArray of Size 3
//int[] arr = {2,5,1,8,2,9,1};
//sliding window fixed question

public class MaxSubArOfFixedSize {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int windowSize = 3;
        //  maxSum(arr,windowSize);
        System.out.println(maxSum(arr, windowSize));
    }

    public static int maxSum(int[] ar, int windowSize) {
        int st = 0;
        int e = 0;
        int sum = 0;

        for (int i = 0; i < ar.length; i++) {
            if (e  <= windowSize) {
                sum = sum + ar[i];
                e++;
            }
            else if (e == windowSize) {
                sum = sum - ar[i];
                st++;
                e++;
            }
        }

        System.out.println("final is :" + sum);
        return sum;
    }

}
