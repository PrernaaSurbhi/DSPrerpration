package com.example.StringPrep;

//this program is to reverse a string using 3 different way  .
//Input:  Techie Delight
//
//Output: thgileD eihceT

import java.util.Stack;

public class StingReverseByThreeWay {
    public static void main(String[] args){
        String str = "Techie Delight";
        char[] c = str.toCharArray();

        //changes using inPlaceConversion
        inPlaceConversion(c);
        String strByPlaceChange = new String(c);
        System.out.println("using swaping the place  : "+strByPlaceChange);

        //change for java inBuilt method
        System.out.println("java build in way : "+builtInJavaMethod(str));

        //changes for stack
        reverseUsingStack(c);
        String strByStack = new String(c);
        System.out.println("using stack  : "+strByStack);

    }

    public static String builtInJavaMethod(String str){
        String rev = new StringBuilder(str).reverse().toString();
        return rev;
    }

    public static void reverseUsingStack(char[] c){
        Stack<Character> s1 = new Stack<>();
        int len = c.length;
        int k = 0;

        for(int i = 0 ; i < len ; i++){
            s1.push(c[i]);
        }
        //pop charcter from stack until it is empty
        while(!s1.empty()){
            c[k++] = s1.pop();
        }
    }

    public static void inPlaceConversion(char[] c) {
        int begin = 0;
        int end = c.length - 1;

        //do till two end point intersect
        while(begin < end){
            swap(c,begin++,end--);
        }
    }

    public static void swap(char[] a, int i , int j){
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}
