package com.example.SlidingWindow;

//find the max  sum of subArray of Size 3
//int[] arr = {2,5,1,8,2,9,1};
//sliding window fixed question

public class MaxSubArOfFixedSize {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int windowSize = 3;
        //  maxSum(arr,windowSize);
        System.out.println(maxSum(arr, windowSize));
    }

    public static int maxSum(int[] ar, int k) {
        int n = ar.length;
        int max_value = Integer.MIN_VALUE;
        int current_runSum = 0;

        for(int i = 0 ; i< n; i++){
            current_runSum += ar[i];

            if(i >= k - 1){
                max_value = Math.max(max_value,current_runSum);
                current_runSum = current_runSum - ar[i - (k - 1)];
            }
        }
        return max_value;
    }
}
