
fun main(args: Array<String>) {
    val input = arrayOf(4,1,2,1,2).toIntArray()
    println(Solution().singleNumber(input))
}

class Solution {
    fun singleNumber(nums: IntArray): Int {
        val hashMap = mutableMapOf<Int, Int>()

        nums.forEach {
            val currentValue = hashMap[it] ?: 0
            hashMap[it] = currentValue + 1
        }

        return hashMap.filterValues { it == 1 }.keys.first()
    }
}