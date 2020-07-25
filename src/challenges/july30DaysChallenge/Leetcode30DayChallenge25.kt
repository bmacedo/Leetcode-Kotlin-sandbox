package challenges.july30DaysChallenge


/**
 * Find Minimum in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 3, 4, 5)

    println(Leetcode30DayChallenge25.findMin(input))
}


object Leetcode30DayChallenge25 {

    // O(log n)
    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex

        while (start < end) {
            val mid = start + (end - start) / 2
            when {
                nums[mid] < nums[end] -> end = mid
                nums[mid] > nums[end] -> start = mid + 1
                else -> end -= 1
            }
        }
        return nums[start]
    }

    // O(n)
    fun findMinSlow(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val min = nums[0]
        for (i in 1 until nums.size) {
            val num = nums[i]
            if (num < min) return num
        }
        return min
    }
}
