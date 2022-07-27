package com.example.SlidingWindow;

//"aabbcc", k = 3
//There are substrings with exactly 3 unique characters
//{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
//Max is "aabbcc" with length 6.

import java.util.HashMap;

public class LongestSubStrWithKChar {
    public static void main(String[] args) {
        String str = "aabcbcdbca";
        int k = 2;
        getLongSubWithUqChar(str, k);
        System.out.println("final result is : "+getLongSubWithUqChar(str, k));
    }

    public static int getLongSubWithUqChar(String str, int k) {
        int maxlen = 0;
        String subStr = "";
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //code for aquire the data when size is less
            while(i< str.length() -1) {
                f1 = true;
                i++;
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(i, 0));

                if (map.size() < k) {
                    continue;
                } else if (map.size() == k) {
                    int len = i - j;
                    if (len > maxlen) {
                        maxlen = len;
                    }
                } else {
                    break;
                }
            }

            //code for release
            while(j < i){
                f2 = false;
                j++;
                char c1 = str.charAt(j);
                if(map.get(c1) == 1){
                    map.remove(c1);
                }else{
                    map.put(c1,map.get(c1)-1);
                }

                if(map.size() > k){
                    continue;
                }else if(map.size() == k){
                    int len = i - j ;
                    if(len > maxlen){
                        maxlen = len;
                    }
                }

            }


            if ((f1 == false) && (f2 == false)) {
                break;
            }
        }
        return maxlen;
    }

}




