package com.example.SlidingWindow;

//Group anagrams together from a list of words

//Input "eat","tea","tan","ate","nat","bat"
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] stringAr = {"eat","tea"};
        System.out.println(groupAnagram(stringAr));
    }

    public static ArrayList<ArrayList<String>> groupAnagram(String[] stringAr) {
        HashMap<Character, Integer> innerMap = new HashMap<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bigHm = new HashMap<>();

        for (int i = 0; i < stringAr.length; i++) {
            String str = stringAr[i];

            for (char c : str.toCharArray()) {
                innerMap.put(c, innerMap.getOrDefault(c,0)+1);
            }

            if (bigHm.containsKey(innerMap) == false) {
                ArrayList<String> arList = new ArrayList<>();
                arList.add(str);
                bigHm.put(innerMap, arList);
            } else {
                ArrayList<String> arList2 = bigHm.get(innerMap);
                arList2.add(str);
            }
        }

        ArrayList<ArrayList<String>> finalList = new ArrayList<>();

        for (ArrayList<String> listItem : bigHm.values()) {
            finalList.add(listItem);
        }
        return finalList;
    }
}
