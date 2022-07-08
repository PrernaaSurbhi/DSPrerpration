package com.example.StringPrep;
// I/P - "cbaabcab"
// O/p - ba

public class RemoveCharacterOccurance {
    public static void main(String[] args){
        String s = "cbaabcab";
        // BA
        char[] ch = s.toCharArray();
        removeCharOccurance(ch);
        System.out.println(removeCharOccurance(ch));
    }

    public static char[] removeCharOccurance(char[] ch){

        int len = ch.length;
        char[] result =  new char[len];

        for(int i = 0; i< len; i++ ){

            if (ch[i] != 'c' && ch[i] != 'a') {
                result[i] = ch[i];
                i++;
            }

            if ((ch[i] == 'a') && !(ch[i + 1] == 'b')) {
                result[i] = ch[i];
                i++;
            }

            if ((ch[i] == 'a') && (ch[i + 1] == 'b') && ((i + 1) != len)) {
                i = i + 2;
            }

        }

        return result;
    }

}

