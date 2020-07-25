package challenges.april30DaysChallenge

/**
 * Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
fun main(args: Array<String>) {
    val input = arrayOf(4,1,2,1,2).toIntArray()
    println(Leetcode30DayChallenge1.singleNumber(input))
}

object Leetcode30DayChallenge1 {

    // O(n) time, O(n) space
    fun singleNumber(nums: IntArray): Int {
        val hashMap = mutableMapOf<Int, Int>()

        nums.forEach {
            val currentValue = hashMap[it] ?: 0
            hashMap[it] = currentValue + 1
        }

        return hashMap.filterValues { it == 1 }.keys.first()
    }
}


