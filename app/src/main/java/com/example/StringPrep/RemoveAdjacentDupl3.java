package com.example.StringPrep;

public class RemoveAdjacentDupl3 {
    public static void main(String[] args){
        String str = "AABBBCDDD";
        removeAdjDu(str);
        System.out.println(" final result "+removeAdjDu(str));
    }

    public static String removeAdjDu(String str) {

        if (str == null) {
            return null;
        }

        char[] ch = str.toCharArray();
        char prev = 0 ;
        int k = 0;

        for(char c : ch){
            if(prev != c ){
                ch[k++] = c;
                prev = c ;
            }
        }

        return new String(ch).substring(0,k);

    }

}
