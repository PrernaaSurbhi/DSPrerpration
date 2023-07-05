/**
 * Created by PrernaSurbhi on 05/07/23.
 */
package com.example.StringPrep;

public class reverseString {
    public static void main(String[] args)  {
        String str1 = "ABC";
        System.out.println(reverseString(str1));
    }

    public static boolean reverseString(String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;

       // StringBuilder str2= new StringBuilder();
        String str2 ="";

        for(int i= len-1; i>=0 ;i--){
            str2 += ch[i];
          //  str2.append(ch[i]);
        }

        System.out.println("reverse string is :" + str2);
        System.out.println("string is :" + str);



        return str.equalsIgnoreCase(str2.toString());
    }
}
