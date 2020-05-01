package april30DaysChallenge


/**
 * Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
fun main(args: Array<String>) {
    val target = 0
    val input = intArrayOf(4, 5, 6, 7, 0, 1, 2) // expect: 4

    println(Leetcode30DayChallenge19.search(input, target))
}

object Leetcode30DayChallenge19 {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        var first = 0
        var last = nums.lastIndex
        if (nums[first] == target) {
            return 0
        } else if (nums[last] == target) {
            return last
        }

        var midPoint = (last - first) / 2

        while (midPoint in nums.indices && last >= first) {
            if (nums[midPoint] == target) {
                return midPoint
            } else {
                val isFirstHalfSorted = nums[first] <= nums[midPoint]
                val isSecondHalfSorted = nums[midPoint] <= nums[last]

                if (isFirstHalfSorted) {
                    if (target >= nums[first] && target < nums[midPoint]) {
                        // go to first half
                        last = midPoint - 1
                        midPoint = (last + first) / 2
                    } else {
                        // go to second half
                        first = midPoint + 1
                        midPoint = (last + first) / 2
                    }

                } else if (isSecondHalfSorted) {
                    if (target > nums[midPoint] && target <= nums[last]) {
                        // go to second half
                        first = midPoint + 1
                        midPoint = (last + first) / 2
                    } else {
                        // go to first half
                        last = midPoint - 1
                        midPoint = (last + first) / 2
                    }
                } else {
                    return -1
                }
            }
        }
        return -1
    }
}
