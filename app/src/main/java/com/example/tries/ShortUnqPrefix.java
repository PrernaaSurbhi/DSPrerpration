package com.example.tries;
//This question is to find shortest unique prefix.
//Output: [A, BON, BOO, CAS, CAT, CH]

import java.util.HashMap;
import java.util.Map;

public class ShortUnqPrefix {
    public static void main(String[] args) {
        String[] words = {
                "AND", "BONFIRE", "BOOL", "CASE", "CATCH", "CHAR"
        };

        findShortestPrefix(words);
    }

    public static void findShortestPrefix(String[] words){
        //construct tries from a given item
        TrieNode rootNode = new TrieNode();

        for(String s :words){
            insert(s,rootNode);
        }

        //recursive traverse the tries in a preorder fashion to list all prefix.

        printShortestPrefix(rootNode, "");
    }

    public static void printShortestPrefix(TrieNode root , String words_so_far){
        if(root == null){
            return;
        }

        //print words_so_far if the current tries node is visited only once
        if(root.freq == 1){
            System.out.println(words_so_far);
            return;
        }

        //recur all child nodes
        for(Map.Entry<Character,TrieNode> child: root.child.entrySet()){
            printShortestPrefix(child.getValue(),words_so_far + child.getKey());
        }
    }

    //function to insert element in trie
    public static void insert(String str,TrieNode root){
        //start from root node.
        TrieNode curr = root;
        for(char c :str.toCharArray()){
            //create a node if the path doesn't exist

            //HashMap.putIfAbsent()
            //If the specified key is not already associated with a value (or is mapped to null) associates
            // it with the given value and returns null,
            // else returns the current value.
            curr.child.putIfAbsent(c,new TrieNode());

            //increase frequency
            curr.child.get(c).freq++;

            //go to next node
            curr = curr.child.get(c);
        }
    }

    public static class TrieNode{

        // each node stores a map to its child nodes
        Map<Character, TrieNode> child = new HashMap<>();

        //keep track of the total number of times the current node is visited.
        //while inserting data in tries.
        int freq = 0;

    }
}
