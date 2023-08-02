package com.example.SlidingWindow

object lengthofLongestSubStr {
    @JvmStatic
    fun main(args: Array<String>){
        val str = "pwwkew"
        println(lengthOfSubString(str))
    }

    fun lengthOfSubString(str:String):Int{
        var i = 0
        var j = 0
        var max = 0
        var len: Int

        var set = HashSet<Char>();

        var charArr = str.toCharArray()

        if(str.isNullOrEmpty()){
            return 0
        }

        while(i<str.length){
            var c = charArr[i]
            while (set.contains(c)){
                set.remove(charArr[j])
                j++
            }
            set.add(c)
            len = i-j+1

            if(len > max){
                max = len
            }
            i++
        }

       return max
    }
}