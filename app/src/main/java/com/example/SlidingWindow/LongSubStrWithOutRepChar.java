package com.example.SlidingWindow;

//find longest substring without repeating character

//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.

import java.util.HashMap;

public class LongSubStrWithOutRepChar {
    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubStr(s);
    }

    public static int LongestSubStr(String str) {
        int maxlen = 0;
        int i = 0;
        String finalStr = "";
        HashMap<Character, Integer> map = new HashMap<>();

        while (i < str.length() - 1) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                char ch = str.charAt(i);
                String s = Character.toString(ch);
                finalStr = finalStr + s;
                int len = finalStr.length();
                if (len > maxlen) {
                    maxlen = len;
                }
                i++;
            } else if (map.containsKey(c)) {
                map.clear();
                finalStr = "";
            }
        }

        System.out.println("longest str is : " + finalStr);
        System.out.println(" maxlen is :" + maxlen);
        return maxlen;

    }
}
