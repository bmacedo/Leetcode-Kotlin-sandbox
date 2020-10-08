package challenges.october30DaysChallenge


/**
 * Binary Search
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums.
 *
 * If target exists, then return its index, otherwise return -1.
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
    val target = 9
    println(Day8.search(nums, target))
}

object Day8 {

    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val mid = start + (end - start) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] > target -> end = mid - 1
                else -> start = mid + 1
            }
        }
        return -1
    }
}