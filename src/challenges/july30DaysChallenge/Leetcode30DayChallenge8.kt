package challenges.july30DaysChallenge

import java.util.*


/**
 * 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)
    println(Leetcode30DayChallenge8.threeSum(nums))
}

object Leetcode30DayChallenge8 {

    fun threeSum(nums: IntArray): List<List<Int>> {

        val arr = nums.sortedArray()

        val triplets = arrayListOf<ArrayList<Int>>()

        for (i in 0..arr.size - 2) {
            if (i > 0 && arr[i] == arr[i - 1]) continue
            findPair(arr, -arr[i], i + 1, triplets)


        }
        return triplets
    }

    private fun findPair(arr: IntArray, targetSum: Int, left: Int, triplets: ArrayList<ArrayList<Int>>) {
        var left = left
        var right = arr.lastIndex

        while (left < right) {
            val currSum = arr[left] + arr[right]

            when {
                currSum == targetSum -> {
                    triplets.add(arrayListOf(-targetSum, arr[left], arr[right]))

                    left++
                    right--

                    while (left < right && arr[left] == arr[left - 1]) left++
                    while (left < right && arr[right] == arr[right + 1]) right--
                }
                currSum < targetSum -> left++
                else -> right--
            }
        }
    }

    fun threeSumSlow(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return emptyList()

        val result = HashSet<List<Int>>()
        val set = HashSet<Int>()

        // Sorting so that order is always same and set can detect a duplicate
        nums.sort()

        set.add(nums[0])
        for (i in 1 until nums.size) {

            val a = nums[i]
            for (j in i + 1 until nums.size) {
                val b = nums[j]
                val c = 0 - (a + b)

                if (set.contains(c)) {
                    result.add(listOf(c, a, b))
                }
            }

            set.add(a)
        }

        return result.toList()
    }
}
