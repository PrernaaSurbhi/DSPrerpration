package com.example.StringPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//This question is to group anagram.

//output -- [[tan, nat], [bat], [eat, tea, ate]]

public class AnagramInStrSet {

    public static void main(String[] args) {
        String[] words = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(groupAnagrams(words));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int strLen = strs.length;

        //Base condition if
        if (strLen == 0) {
            return result;
        }

        //create a hashmap to map a key with the set of anagrams which correspond to the key
        HashMap<String, List<String>> map = new HashMap<>();

        //traverse the array string by string
        for (int i = 0; i < strLen; i++) {

            //generate a key for current String
            String key = getKeySet(strs[i]);

            //if the key is not present in the map, create a new list to store anagrams corresponding to this new key
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            //when key is already present in a list

            map.get(key).add(strs[i]);

        }

        result.addAll(map.values());

        return result;
    }

    //method to get answer using sort array
//    public static String genKey(String str){
//        char[] arr = str.toCharArray();
//
//        //sort the letters
//        Arrays.sort(arr);
//
//        //return the key
//        return new String(arr);
//
//    }

    public static String getKeySet(String str) {
        HashMap<Character, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char keyCh = str.charAt(i);
            keyMap.put(keyCh, keyMap.getOrDefault(keyCh, 0) + 1);
        }

        return keyMap.keySet().toString();
    }

}
