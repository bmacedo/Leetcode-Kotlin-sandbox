package challenges.august30DaysChallenge


/**
 * Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[ i ] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 */
fun main(args: Array<String>) {
    val input = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    println(Leetcode30DayChallenge6.findDuplicates(input))
}

object Leetcode30DayChallenge6 {

    // Be wary of the conditions given: any element must have value between 1 and the size of the array
    fun findDuplicates(nums: IntArray): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            val n = Math.abs(nums[i])
            if (nums[n - 1] < 0) {
                list.add(n)
            } else {
                nums[n - 1] = -nums[n - 1]
            }
        }
        return list
    }
}