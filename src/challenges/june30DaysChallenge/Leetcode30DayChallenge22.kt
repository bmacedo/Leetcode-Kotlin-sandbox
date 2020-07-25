package challenges.june30DaysChallenge


/**
 * Single Number II
 *
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
fun main(args: Array<String>) {
    val input = arrayOf(2, 2, 2, 1).toIntArray()
    println(Leetcode30DayChallenge22.singleNumber(input))
}

object Leetcode30DayChallenge22 {

    // O(n) time, O(n) space
    fun singleNumber(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val count = HashMap<Int, Int>() // Int, Count
        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }
        return count.filterValues { it == 1 }.keys.first()
    }

}
