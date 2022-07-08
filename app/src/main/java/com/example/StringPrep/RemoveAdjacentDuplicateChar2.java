package com.example.StringPrep;

public class RemoveAdjacentDuplicateChar2 {
    public static void main(String[] args){
        String str = "AABBBCDDD";
        removeAdjDupl(str);
        System.out.println(" final result "+removeAdjDupl(str));
    }

    public static String removeAdjDupl(String str){

        if(str == null){
            return null;
        }

        char[] ch = str.toCharArray();
        int len = ch.length;
        char[] c1 = new char[len];
        String rev = "";

        for(int i = 1 ; i< len; i++){
            c1[0] = ch[0];

            if(ch[i-1] != ch[i]){
                c1[i] = ch[i];
            }
        }

        for(char c :c1){
            rev += c;
        }

        return rev;
    }

}
