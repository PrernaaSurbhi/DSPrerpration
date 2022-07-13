package com.example.DynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("enter array length of combination: ");
        int coinCombinationSize = s.nextInt();

        int[] coinCombinationArray = new int[coinCombinationSize];

        for(int i = 0 ; i < coinCombinationArray.length ; i++){
            System.out.print("enter coin");
            coinCombinationArray[i] = s.nextInt();
        }

        System.out.println("enter target coin:");
        int targetCoin = s.nextInt();

        targetCoinCombination(targetCoin,coinCombinationArray);
    }

    public static int targetCoinCombination(int targetCoin,int[] coinCombinationArray ){
        int[] dp = new int[targetCoin+1];
        dp[0] = 1 ;

        for(int i = 0 ; i < coinCombinationArray.length ; i++){
            for(int j =  coinCombinationArray[i] ; j< dp.length ; j++){
                dp[j] = dp[j]+ dp[j -coinCombinationArray[i]];
            }
        }

        for(int element:dp){
            System.out.println("each elemnt : "+element);
        }

        System.out.println("final result : "+dp.length);

        System.out.println("element at target "+dp[targetCoin]);
        return dp.length;
    }

}
