package com.example.StringPrep;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MaxiOccuranceWord {
    public static void main(String[] args) throws IOException {
        String[] strArray = { "code", "coder", "coding",
                "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence"
                , "codex", "codify", "codependents", "codes",
                "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"};

        getmaximumOccurenceWord(strArray);
    }

    public static void getmaximumOccurenceWord(String[] strArray){
        int len = strArray.length;
        int j = 0 ;
        int highestVal = 0;
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0 ; i< len ; i++){
            if(map.containsKey(strArray[i])){
                int value = map.get(strArray[i]);
                map.put(strArray[i],value+1);
            }else{
                map.put(strArray[i],1);
            }
        }

        while( j < len){
            int value = map.get(strArray[j]);
            if(highestVal < value){
                highestVal = value;
            }
            j++;
        }

        System.out.println("highest value is : "+highestVal);
        System.out.println("The maximum occurring word is : "+getKey(map, highestVal));

    }

    public static <K, V> K getKey(HashMap<K, V> map, V value)
    {
        for (HashMap.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
