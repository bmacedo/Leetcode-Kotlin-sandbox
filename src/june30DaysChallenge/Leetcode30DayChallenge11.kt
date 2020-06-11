package june30DaysChallenge

/**
 * Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects
 * of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 */
fun main(args: Array<String>) {
    val list = intArrayOf(2, 0, 2, 1, 1, 0)
    Leetcode30DayChallenge11.sortColors(list)
    println(list.toList())
}

object Leetcode30DayChallenge11 {

    fun sortColors(nums: IntArray) {
        var lastZero = 0
        var firstTwo = nums.lastIndex
        var i = 0
        while (i <= firstTwo) {
            when {
                nums[i] == 0 -> {
                    swap(nums, lastZero, i)
                    lastZero++
                    i++
                }
                nums[i] == 2 -> {
                    swap(nums, firstTwo, i)
                    firstTwo--
                }
                else -> i++
            }
        }
    }

    private fun swap(nums: IntArray, from: Int, to: Int) {
        val temp = nums[from]
        nums[from] = nums[to]
        nums[to] = temp
    }

    // Counting sort. Two pass
    fun sortColorsTwoPass(nums: IntArray) {
        val count = IntArray(3)
        nums.forEach { count[it]++ }
        for (i in nums.indices) {
            when {
                count[0] > 0 -> {
                    nums[i] = 0
                    count[0]--
                }
                count[1] > 0 -> {
                    nums[i] = 1
                    count[1]--
                }
                count[2] > 0 -> {
                    nums[i] = 2
                    count[2]--
                }
            }
        }
    }
}