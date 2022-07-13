package com.example.DynamicProgramming;
//  n ---- rows.
//  m ---- columns.
// n*m --- array a --- gold mines
//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion
// You are standing in front of left wall and are supposed to dig to the right wall. You can start from
//     any row in the left wall.
// You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).

import java.util.Scanner;

public class GoldDigging {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ar = new int[n][m];


        //This is for representing 2d array for filling the gold amonth on row and column
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                ar[i][j] = sc.nextInt();
            }
        }

        int[] rowSum = new int[n];
        int maxGoldprice = 0;


        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                //for first row
                if (i == 0) {
                    rowSum[i] = rowSum[i] + Math.max(ar[i][j + 1], ar[i + 1][j + 1]);
                    System.out.println(" rowSum[i] :" + rowSum[i]);
                }
                // for last row
                else if (i == n - 1) {
                    rowSum[i] = rowSum[i] + Math.max(ar[i][j + 1], ar[n - 2][j + 1]);
                } else {
                    rowSum[i] = rowSum[i] + Math.max(Math.max(ar[i - 1][j + 1], ar[i][j + 1]), ar[i + 1][j + 1]);
                }


                if (maxGoldprice < rowSum[i]) {
                    maxGoldprice = rowSum[i];
                }
            }

        }

        System.out.println("price of gold is :" + maxGoldprice);
    }
}
