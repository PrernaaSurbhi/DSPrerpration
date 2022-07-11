package com.example.DynamicProgramming;

import java.util.Scanner;

public class ClimbingStair {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cp = countpath(6,new int[6 + 1]);
        System.out.println(cp);
    }

    public static int countpath(int n, int[] qb ){
        //base case
        if(n == 0 ){
            return 1;
        }else if(n < 0){
            return 0;
        }

        if(qb[n]>0){
            return qb[n];
        }

       int nm1 = countpath(n-1,qb);
       int nm2 = countpath(n-2 ,qb);
       int nm3 = countpath(n-3,qb);
       int cp = nm1 + nm2 +nm3;

       qb[n] = cp;
       return cp;
    }
}
