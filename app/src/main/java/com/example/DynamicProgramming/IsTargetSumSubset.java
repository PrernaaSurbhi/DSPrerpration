package com.example.DynamicProgramming;

import java.util.Scanner;

//subset is a combination of serial or non serail combination
//subarray is a combination of serial element

public class IsTargetSumSubset {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of array: ");
        int n = sc.nextInt();
        int[] ar = new int[n];

        //code for adding data dynamically for array element
        for(int i = 0 ; i< ar.length; i++){
            System.out.println("enter number :");
            ar[i] = sc.nextInt();
        }

        System.out.println("enter the target :");
        int target = sc.nextInt();
        boolean dp[][] = new boolean[n+1][target+1];
        isIsTargetSumSubsetFound(target,dp,ar);

    }

    public static void isIsTargetSumSubsetFound(int target,boolean dp[][],int[] ar){

        for(int i = 0 ; i< dp.length ; i++){
            for(int j = 0 ; j< dp[0].length ; j++ ){
                if(i == 0 && j == 0 ){
                    dp[i][j] = true;
                }
                else if(i== 0){
                    dp[i][j] = false;
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                else {
                    if(dp[i-1][j]== true){
                        dp[i][j]= true;
                    }else{
                        int val = ar[i-1];
                        if(j>= val){
                            if(dp[i-1][j-val] == true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }


        }
        System.out.println("final result is :"+dp[ar.length][target]);
    }
}
