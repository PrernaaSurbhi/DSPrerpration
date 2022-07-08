package com.example.StringPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringAnagram {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("enter string S1: ");
            String s1 = reader.readLine();

            System.out.print("enter string S2: ");
            String s2 = reader.readLine();

        foundAnagram(s1,s2);

        if(foundAnagram(s1,s2)){
            System.out.print("Anagram found :");
        }else {
            System.out.print("Anagram  not found :");
        }


    }

    public static boolean foundAnagram(String s1 ,String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] ch1 = s1.toLowerCase().toCharArray();
            char[] ch2 = s2.toLowerCase().toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);

            return Arrays.equals(ch1, ch2);
        }

    }
}
