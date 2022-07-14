package com.example.DynamicProgramming;

import java.util.Scanner;
//count binary string of length n , which is not having consecutive 0.

public class CountBinaryString {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("enter array size: ");
        int n = s.nextInt();

        int[] dpo = new int[n+1];
        int[] dp1 = new int[n+1];

        dpo[1] = 0;
        dp1[1] = 0;

        for(int i = 2 ; i <= n ; i++){
            dp1[i] = dp1[i-1] + dpo[i-1];
            dpo[i] = dp1[i-1];
        }

        System.out.println("final result is : "+dpo[n]+dp1[n]);

    }
}
