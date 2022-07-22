package com.example.SlidingWindow;
//This program is to find count occourance of anagram

import java.util.HashMap;

public class CountOccuranceOfAnagram {
    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String p = "for";

        findAnagrams(s, p);
    }

    public static void findAnagrams(String s, String p) {
        // write your code here
        HashMap< Character, Integer> smap = new HashMap< >();
        HashMap< Character, Integer> pmap = new HashMap< >();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            int ofreq = pmap.getOrDefault(ch, 0);
            pmap.put(ch, ofreq + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            int ofreq = smap.getOrDefault(ch, 0);
            smap.put(ch, ofreq + 1);
        }

        int j = 0;
        int i = p.length();
        int count = 0;
        String str = "";

        while (i < s.length()) {
            if (compare(pmap, smap) == true) {
                count++;
                str += j + " ";
            }

            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha, 0) + 1);

            char chr = s.charAt(j);

            if (smap.get(chr) == 1) {
                smap.remove(chr);
            } else {
                smap.put(chr, smap.get(chr) - 1);
            }

            i++;
            j++;
        }

        if (compare(pmap, smap) == true) {
            count++;
            str += j + " ";
        }

        System.out.println(count);
        System.out.println(str);
    }


    public static boolean compare(HashMap< Character, Integer> pmap, HashMap< Character, Integer> smap) {
        for (char sch : smap.keySet()) {
            if (smap.get(sch) != pmap.getOrDefault(sch, 0)) {
                return false;
            }
        }
        return true;
    }
}
