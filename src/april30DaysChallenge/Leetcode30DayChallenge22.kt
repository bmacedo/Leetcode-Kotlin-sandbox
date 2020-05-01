package april30DaysChallenge

import java.util.*


/**
 * Subarray Sum Equals K
 *
 * Given an array of integers and an integer k, you need to find
 * the total number of continuous subarrays whose sum equals to k.
 *
 * Note:
 * -    The length of the array is in range [1, 20,000].
 * -    The range of numbers in the array is [-1000, 1000] and the
 *      range of the integer k is [-1e7, 1e7].
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 1, 1)
    val k = 2 // expect: 2

    println(Leetcode30DayChallenge22.subarraySum(input, k))
}

object Leetcode30DayChallenge22 {

    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) return -1

        val map = HashMap<Int, Int>()
        map[0] = 1
        var preSum = 0
        var count = 0

        for (element in nums) {
            preSum += element
            if (map.containsKey(preSum - k)) {
                count += map[preSum - k]!!
            }
            map[preSum] = map.getOrDefault(preSum, 0) + 1
        }
        return count
    }
}
