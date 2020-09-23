package challenges.september30DaysChallenge

import java.util.*


/**
 * Majority Element II
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 */
fun main(args: Array<String>) {
    println(Day22.majorityElement(intArrayOf(1, 2)))
}

object Day22 {

    // O(n) time, O(1) space. Boyer-Moore voting algorithm
    fun majorityElement(nums: IntArray): List<Int> {
        // 1st pass
        var count1 = 0
        var count2 = 0

        var candidate1: Int? = null
        var candidate2: Int? = null

        for (n in nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++
            } else if (candidate2 != null && candidate2 == n) {
                count2++
            } else if (count1 == 0) {
                candidate1 = n
                count1++
            } else if (count2 == 0) {
                candidate2 = n
                count2++
            } else {
                count1--
                count2--
            }
        }

        // 2nd pass
        val result = ArrayList<Int>()

        count1 = 0
        count2 = 0

        for (n in nums) {
            if (candidate1 != null && n == candidate1) count1++
            if (candidate2 != null && n == candidate2) count2++
        }

        val n = nums.size
        if (count1 > n / 3) result.add(candidate1!!)
        if (count2 > n / 3) result.add(candidate2!!)

        return result
    }

    // O(n logn)
    fun majorityElementSlow(nums: IntArray): List<Int> {
        if (nums.isEmpty()) return emptyList()
        if (nums.size == 1) return listOf(nums[0])

        val minReps = Math.floor(nums.size / 3.0)

        if (minReps < 1) return nums.toSet().toList()

        nums.sort()
        val result = mutableSetOf<Int>()
        var count = 1
        var item = nums[0]
        for (i in 1 until nums.size) {
            val newItem = nums[i]
            count = if (item == newItem) count + 1 else 1
            if (count > minReps) result.add(item)
            item = newItem
        }
        return result.toList()
    }
}