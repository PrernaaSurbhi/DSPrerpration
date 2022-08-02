package com.example.SlidingWindow;

import java.util.HashMap;
import java.util.Set;

public class TrnsStrSingleEdit {
    public static void main(String[] args) {
        String str1 = "xyz";
        String str2 = "xyyz";
        System.out.println(isStrTransform(str1,str2));
    }

    public static boolean isStrTransform(String str1,String str2){
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();

        for(int j =0 ; j < str2.length() ; j++){
            char c = str2.charAt(j);
            hm2.put(c, hm2.getOrDefault(c,0)+1);
        }

        for(int i =0 ; i < str1.length() ; i++){
             char c = str1.charAt(i);
             hm1.put(c, hm1.getOrDefault(c,0)+1);
        }

        Set hmSet1 = hm1.entrySet();
        Set hmSet2 = hm2.entrySet();


        if(str1.length() == str2.length()){
            if(hmSet1.equals(hmSet2)){
                return false;
            }else{
                int keyset1Len = hm1.keySet().size();
                int keyset2len = hm2.keySet().size();
                return (keyset1Len - keyset2len == 1) || (keyset2len - keyset1Len == 1);
            }
        }else{
            int unEqualKeySet1 = hm1.keySet().size();
            int unEqualKeySet2 = hm2.keySet().size();
            System.out.println("keySet1 Len is:"+unEqualKeySet1);
            System.out.println("keySet2 Len is:"+unEqualKeySet2);
            if(unEqualKeySet1 == unEqualKeySet2 &&
                    ((str1.length()- str2.length() == 1) || (str2.length() - str1.length() ==1))){
                System.out.println("ha ha i am equal here");
                return true;
            }
            return (unEqualKeySet1 - unEqualKeySet2 == 1) || (unEqualKeySet1 - unEqualKeySet2 == 1);
        }

    }
}
