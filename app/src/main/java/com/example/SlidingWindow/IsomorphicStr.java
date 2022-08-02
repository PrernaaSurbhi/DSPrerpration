package com.example.SlidingWindow;

//Given two strings, determine whether they are isomorphic.
// Two strings, X and Y, are called isomorphic if all occurrences
    // of each character in X can be replaced with another character to get Y and vice-versa.

//    String str1 = "ACAB";
//    String str2 = "XCXY";
//output true

//    String str1 = "foo";
//    String str2 = "bar";
//output false


// String str1 = "badc"
// String str2 = "baba"
//output  false

import java.util.HashMap;

public class IsomorphicStr {
    public static void main(String[] args) {
        String str1 = "badc";
        String str2 = "baba";

        isIsomorphic(str1, str2);
        System.out.println(isIsomorphic(str1,str2));
    }

    public static boolean isIsomorphic(String str1, String str2) {
        HashMap<Character, Character> map = new HashMap<>();

        if (str1.length() != str2.length()) {
            return false;
        } else {
            for (int i = 0; i < str1.length(); i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if (map != null) {
                    boolean k1 = map.containsKey(c1);
                    boolean keySimilar = map.containsKey(c2);
                    if (!k1 && !keySimilar) {
                        map.put(c1, c2);
                    }else if(!k1 && keySimilar){
                        return false;
                    }
                    else {
                        char chAtStr2 = str2.charAt(i);
                        char charAtMapOnSameKey = map.get(str1.charAt(i));

                        if (chAtStr2 != charAtMapOnSameKey) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }


    }
}
