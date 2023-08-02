/**
 * Created by PrernaSurbhi on 02/08/23.
 */
package com.example.ArraySortingAlgorthm;

public class QuickSortJava {
    public static void main(String args[]) {
        int[] ar = {8, 7, 2, 1, 0, 9, 6};
        int n = ar.length;
        quickSort(0,n-1,ar);
        printSortedArray(ar);
    }

    public static void quickSort(int l,int h,int[] ar){
        if(l < h){
            int pivot = getPivot(l,h,ar);
            quickSort(l,pivot-1,ar);
            quickSort(pivot+1, h,ar);
        }
    }

    public static int getPivot(int l, int h ,int[] ar){
        int pivot = ar[l];
        int i = l;
        int j = h;

        while(i < j){
            while(ar[i] <= pivot && i < ar.length -1) {
                i++;
            }
            while(ar[j] > pivot){
                j--;
            }
            if(i<j){
                swap(i,j,ar);
            }
        }

        swap(l,j,ar);

        return j;
    }

    public static void swap(int l, int h,int[] ar){
        int temp = ar[l];
        ar[l] = ar[h];
        ar[h] = temp;
    }

    public static void printSortedArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}
