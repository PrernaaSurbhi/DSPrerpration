package com.example.DynamicProgramming;

import java.util.Scanner;
//this problem is zero one knapsac problem

public class ZeroOneKnapScap {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("enter item size:");
        int itemSize = s.nextInt();
        int[] itemWt = new int[itemSize];
        int[] itemvalue = new int[itemSize];

        for(int i = 0 ; i< itemvalue.length ; i++){
            System.out.println("enteritem value ");
            itemvalue[i] = s.nextInt();
        }

        for(int j = 0 ; j< itemWt.length ; j++){
            System.out.println("enterweight value ");
            itemvalue[j] = s.nextInt();
        }

        System.out.print("enter capacity:");
        int cap = s.nextInt();

        getMaxprofit(cap , itemSize,itemWt,itemvalue);

    }

    public static int getMaxprofit(int cap ,int itemSize,int[] itemWt, int[] itemvalue){
        int[][] dp = new int[itemSize + 1][cap + 1];
        dp[0][0] = 0;

        for(int i = 1 ; i < dp.length; i++){
            for(int j = 1 ; j < dp[0].length; j++){
                //when i not playing
                dp[i][j] = dp[i-1][j];

                //when ball capacity is there
                if(j >= itemWt[i-1]){
                    int remCapacity = j - itemWt[i-1];

                    if(dp[i-1][remCapacity]+itemvalue[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][remCapacity]+itemvalue[i-1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.print("final max profit is :"+dp[itemSize][cap]+" ");
        return dp[itemSize][cap];
    }
}
