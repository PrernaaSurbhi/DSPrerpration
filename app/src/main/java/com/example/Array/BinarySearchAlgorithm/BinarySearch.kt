package com.example.Array.BinarySearchAlgorithm

import java.util.Arrays

object BinarySearch {
    @JvmStatic
    fun main(args: Array<String>){
        val nums = arrayOf(4,5,6,7,0,1,2)
        val target = 0
        Arrays.sort(nums)
        println("target index is :" + findindex(nums, target))

    }

    fun findindex(nums:Array<Int>,target:Int):Int{
        var s = 0;
        var e = nums.size-1

        while(s<=e){
            var mid = s + (e -s) / 2

            if(target == nums[mid]){
                return mid
            }else if(target > nums[mid]){
                s = mid + 1
            }else{
                e = mid -1
            }
        }

        return -1
    }
}