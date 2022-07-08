package com.example.dsprerpration

/**
 * Created by PrernaSurbhi on 19/02/22.
 */
object SubArraySumFound{
    fun main(args:Array<String>){
        val arr = arrayOf(-1,0,1,2,-1,-4)
        find3sumExist(arr)
    }

    fun find3sumExist(arr: Array<Int>):Boolean{
        var set = HashSet<Int>()
        var sum = 0

        for(item in arr){
            sum = sum.plus(item)
            set.add(sum)
            if(set.contains(item)){
                println("find3sumExist found")
                return true
            }else{
                return false
            }
        }
        return false

    }
}








