package com.example.StringPrep;

//This problem is to remove adjacent duplicate character from string

import java.util.HashSet;

public class RemoveAdjacentDuplicateChar {

    public static void main(String[] args){
        String str = "AABBBCDDD";
        removeAdjDup(str);
        System.out.println(removeAdjDup(str));

    }

    public static String removeAdjDup(String str){
        char[] ch = str.toCharArray();
        int len = ch.length;
       HashSet<Character> set = new HashSet<>();

        for(int i = 0 ; i< len; i++){
            if(!set.contains(ch[i])){
                set.add(ch[i]);
            }
        }


       return  set.toString();
    }


}


