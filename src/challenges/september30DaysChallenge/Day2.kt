package challenges.september30DaysChallenge

import java.util.*


/**
 * Contains Duplicate III
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that:
 * - the absolute difference between nums[ i ] and nums[ j ] is at most t and
 * - the absolute difference between i and j is at most k.
 */
fun main(args: Array<String>) {
    println(Day2.containsNearbyAlmostDuplicate(intArrayOf(-1, Int.MAX_VALUE), 1, Int.MAX_VALUE))
}

object Day2 {

    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (nums.isEmpty() || k <= 0) return false

        val set = TreeSet<Long?>()
        for (i in 0 until nums.size) {
            val floor = set.floor(1L * nums[i] + t)
            val ceil = set.ceiling(1L * nums[i] - t)
            if (floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) return true

            set.add(1L * nums[i])
            if (i >= k) set.remove(1L * nums[i - k])
        }
        return false
    }
}