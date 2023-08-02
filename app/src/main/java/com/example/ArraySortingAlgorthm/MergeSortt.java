/**
 * Created by PrernaSurbhi on 02/08/23.
 */
package com.example.ArraySortingAlgorthm;

public class MergeSortt {
    public static void main(String[] args)  {
        int[] ar = {6, 3, 9, 5, 2, 0, 8};
        int n = ar.length;


        divideArray(ar,0,n-1);

        for(int i = 0;i< n; i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }

    public static void divideArray(int[] ar, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si) / 2;
        divideArray(ar,si,mid);
        divideArray(ar,mid+1,ei);


        conquer(ar,si,mid,ei);
    }

    public static void conquer(int[] ar, int si, int mid ,int ei){
        int[] mergedArray = new int[ei-si+1];

        int idx1 = si;      //starting index of 1st array
        int idx2 = mid+1;       //starting index of 2nd array

        int x = 0;   //starting index of merged index

        while(idx1 <= mid && idx2 <= ei){

            //first element of index1 is smaller than first element of index2
            if(ar[idx1] <= ar[idx2]){
                mergedArray[x] = ar[idx1];
                x++;
                idx1++;
            }else{
                mergedArray[x] = ar[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1 <= mid){
            mergedArray[x] = ar[idx1];
            x++;
            idx1++;
        }

        while(idx2 <= ei ){
            mergedArray[x] = ar[idx2];
            x++;
            idx2++;
        }

        //copy original index to the merged one

        for(int i = 0, j = si; i < mergedArray.length; i++,j++){
            ar[j] = mergedArray[i];
        }
    }
}
