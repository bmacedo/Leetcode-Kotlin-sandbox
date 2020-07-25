package challenges.april30DaysChallenge

/**
 * Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1)
    Leetcode30DayChallenge4.moveZeroes(input)
}

object Leetcode30DayChallenge4 {

    fun moveZeroes(nums: IntArray) {
        var zeroCount = 0

        nums.forEachIndexed { index, num ->
            if (num == 0) {
                zeroCount++
            } else {
                val moveToPosition = index - zeroCount
                // if within the start of the array
                if (moveToPosition >= 0 && zeroCount > 0) {
                    nums[moveToPosition] = num
                    nums[index] = 0
                }
            }
        }

        println(nums.toList())
    }
}
