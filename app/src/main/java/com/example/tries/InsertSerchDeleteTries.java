package com.example.tries;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java  

import java.util.HashMap;
import java.util.Map;

public class InsertSerchDeleteTries {

    public static void main(String[] args){
        String[] words = {
                "AND", "BONFIRE", "BOOL", "CASE", "CATCH", "CHAR"
        };

        TrieNode root = new TrieNode();
        for(int i = 0 ; i< words.length; i++){
            String word = words[i];
            //code for insert the node on the Tries.
            insert(word,root);

        }
        //find the node of the tries exist or not.
        search("AND",root);
        System.out.println("did serach word found: "+search("AND",root));

        //delete the node if found
        delete("BOOL",root,0);
        System.out.println("word got deleted: "+search("AND",root));
    }

    // This method is to delete the node , if find .
    public static boolean delete(String word,TrieNode current, int index){
        //here we want to reach the last node of word
        if(index == word.length()){
              //if end_word_reached only delete the node if end_of_word is true.
            if(!current.endOfWord){
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true.
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(word,node,index +1);
       // if true is returned then delete the mapping of character
        // and trieNode reference from map.

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            //return true if no mapping are left in the map
            return current.children.size() == 0;
        }
        return false;
    }


    //This method is to find  node of the tries exist or not.
    public static boolean search(String word,TrieNode root){
        TrieNode current = root;
        for(int i = 0 ; i< word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for the given char then return false.
            if(node == null){
                return false;
            }

            current = node;
        }
        //if a node found and node end_of_word will be true otherwise it will be false;
        return current.endOfWord;
    }

    public static void insert(String word, TrieNode root){
        TrieNode current = root;

        for(int i = 0 ; i< word.length() ; i++){
            char ch = word.charAt(i);
            TrieNode node= current.children.get(ch);

            //node is null means current node is not inserted , we need to insert it .
            if(node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;

        }
        System.out.println("current inserted node is : "+current.children.entrySet());
        //mark the current nodes endOfWords as true.
        current.endOfWord = true;

    }


    private static class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

}
