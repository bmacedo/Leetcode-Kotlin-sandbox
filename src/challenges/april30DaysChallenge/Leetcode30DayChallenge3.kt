package challenges.april30DaysChallenge

import kotlin.math.max

/**
 * Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println(Leetcode30DayChallenge3.maxSubArray(input))
}

object Leetcode30DayChallenge3 {

    fun maxSubArray(nums: IntArray): Int {
        var previousSum = 0
        var maxSum = Int.MIN_VALUE
        nums.forEach { num ->
            val sum = max(previousSum + num, num)
            previousSum = sum
            if (sum > maxSum) {
                maxSum = sum
            }
        }
        return maxSum
    }
}
