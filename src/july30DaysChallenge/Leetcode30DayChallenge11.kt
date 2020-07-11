package july30DaysChallenge

import java.util.ArrayList


/**
 * Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 3)
    println(Leetcode30DayChallenge11.subsets(input))
}

object Leetcode30DayChallenge11 {

    private val res: MutableList<List<Int>> = ArrayList()
    fun subsets(nums: IntArray): List<List<Int>> {
        if (nums.isNotEmpty()) {
            val curr = mutableListOf<Int>()
            backTrack(0, curr, nums)
        }
        return res
    }

    private fun backTrack(start: Int, curr: MutableList<Int>, nums: IntArray) {
        res.add(ArrayList(curr))
        for (i in start until nums.size) {
            curr.add(nums[i])
            backTrack(i + 1, curr, nums)
            curr.removeAt(curr.size - 1)
        }
    }
}
