package challenges.may30DaysChallenge

/**
 * Single Element in a Sorted Array
 *
 * You are given a sorted array consisting of only integers where every element appears
 * exactly twice, except for one element which appears exactly once.
 *
 * Find this single element that appears only once.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(3,3,7,7,10,11,11)
    println(Leetcode30DayChallenge12.singleNonDuplicate(input))
}

// The idea is to take the middle element, disregard the copies of this element and
// check which side has an odd number of elements. The unique number will be in the
// odd-numbered side.
object Leetcode30DayChallenge12 {

    // O(logn) time, O(1) space
    fun singleNonDuplicate(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex
        while (start < end) {
            val mid = start + ((end - start) ushr 1)
            val separator = if (mid - 1 in nums.indices && nums[mid-1] == nums[mid]) {
                mid
            } else if (mid + 1 in nums.indices && nums[mid+1] == nums[mid]) {
                mid - 1
            } else {
                return nums[mid]
            }
            if ((end - separator) % 2 != 0) {
                start = separator + 1
            } else {
                end = separator
            }
        }
        return nums[start]
    }
}


