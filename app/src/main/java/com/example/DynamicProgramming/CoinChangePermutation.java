package com.example.DynamicProgramming;

import java.util.Scanner;

// need to refactor it
public class CoinChangePermutation {
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

        targetCoinPermutation(targetCoin,coinCombinationArray);
    }

    public static int targetCoinPermutation(int targetCoin,int[] coinCombinationArray ){
        int[] dp = new int[targetCoin+1];
        dp[0] = 1;

        for(int i = 1 ; i< dp.length; i ++){
            for(int coin:coinCombinationArray){
                if(coin <= i){
                    int remaningAmnt = i - coin;
                    dp[i] = dp[i]+dp[remaningAmnt];
                }

            }
        }

        System.out.println("remaing amount is "+dp[targetCoin]);
        return dp[targetCoin];
    }
}
