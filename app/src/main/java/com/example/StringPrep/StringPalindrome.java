package com.example.StringPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Input : "ABCBA"
//        Output: true
//
//        Input : "ABCA"
//        Output: false

public class StringPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("enter string S1: ");
        String s1 = br.readLine();

        isPalindrome(s1);
        System.out.println(" : final result :" + isPalindrome(s1));
    }

    public static boolean isPalindrome(String str) {
        if(str == null){
            return false;
        }

        char[] ch1 = str.toCharArray();
        int len = ch1.length;

        String rev = "";
        for (int i = len - 1; i >= 0; i--) {
            rev += ch1[i];

        }
        System.out.println("reverse string is :" + rev);
        System.out.println("string is :" + str);

        return str.equalsIgnoreCase(rev);

    }
}
