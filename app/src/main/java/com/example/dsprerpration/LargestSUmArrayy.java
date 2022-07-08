package com.example.dsprerpration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PrernaSurbhi on 20/02/22.
 */
public class LargestSUmArrayy {
    public static void main(String[] args){
        int[] arr = {15,-2,2,-8,1,7,10,23};
        String input = "http:\u002f\u002fgoogle.com";
        System.out.println("our output is: "+input);
        //    http://google.com

        getlargest(arr);
    }

    public static int getlargest(int[] arr){
        int maxlength = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int startIndex = -1;
        int n = arr.length -1;
        map.put(sum,startIndex);

        while(startIndex < n){
            startIndex++;
            if(map.containsKey(sum)){
               int index = startIndex - map.get(sum);
               if(index >maxlength){
                   System.out.println(""+index);
                   return index;
               }else{
                   System.out.println(""+maxlength);
                   return maxlength;
               }
            }else{
                sum = sum + arr[startIndex];
                map.put(sum,startIndex);
            }
        }
        System.out.println(""+maxlength);
        return maxlength;
    }
}
