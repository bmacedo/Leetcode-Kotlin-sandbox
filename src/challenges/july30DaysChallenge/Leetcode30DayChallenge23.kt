package challenges.july30DaysChallenge

import java.util.*


/**
 * Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other
 * elements appear exactly twice. Find the two elements that appear only once.
 *
 * Note:
 * - The order of the result is not important. So in the above example, [5, 3] is also correct.
 * - Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 1, 3, 2, 5)

    println(Leetcode30DayChallenge23.singleNumber(input).toList())
}


object Leetcode30DayChallenge23 {

    // O(n) time, O(n) space
    fun singleNumber(nums: IntArray): IntArray {
        val resultSet = HashSet<Int>()
        for (num in nums) {
            if (resultSet.contains(num)) resultSet.remove(num)
            else resultSet.add(num)
        }
        return resultSet.toIntArray()
    }
}
