package com.example.Array.ArraySortingAlgorthm;

////Array before sorting is 80,85,60,90,70
////sorted Array is 60 70 80 85 90
object QuickSortKotlin {
    @JvmStatic
    fun main(arg:  Array<String>){
        val ar = arrayOf(80,85,60,90,70)
        val n = ar.size
        quickSort(ar,0,n-1)
        printSortedElement(ar)
    }

    fun quickSort(ar:Array<Int>,l:Int,h:Int){
        if(l<h){
            val pivot = partition(ar,l,h)
            quickSort(ar,0,pivot-1)
            quickSort(ar,pivot+1,h)
        }
    }

    fun partition(ar:Array<Int>,l:Int,h:Int):Int{
        val pivot = ar[l]
        var i = l
        var j = h

        while(i<j){
            while(ar[i] <= pivot && i< ar.size -1){
                i++
            }

            while(ar[j]> pivot){
                j--
            }

            if(i< j){
                swap(ar,i,j)
            }
        }

        swap(ar,l,j)

        return j
    }

    fun swap(ar:Array<Int>,l:Int,h:Int){
        val temp = ar[l]
        ar[l] = ar[h]
        ar[h] = temp
    }

    fun printSortedElement(ar:Array<Int>){
        for(item in ar){
            print("$item ")
        }
    }
}