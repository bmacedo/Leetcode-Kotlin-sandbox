package thirtyDaysChallenge


/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is
 * equal to the product of all the elements of nums except nums[i].
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the
 * array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, -1)
//    val input = intArrayOf(1, 2, 3,4)
    println(Leetcode30DayChallenge15.productExceptSelf(input).toList())
}

object Leetcode30DayChallenge15 {

    // O(N) time; O(N) space
    fun productExceptSelf(nums: IntArray): IntArray {
        val rightProducts = IntArray(nums.size + 1) { 1 }
        val leftProducts = IntArray(nums.size + 1) { 1 }

        for (index in 1..nums.size) {
            leftProducts[index] = leftProducts[index - 1] * nums[index - 1]
        }

        for (index in nums.lastIndex downTo 0) {
            rightProducts[index] = rightProducts[index + 1] * nums[index]
        }

        for (index in nums.indices) {
            nums[index] = leftProducts[index] * rightProducts[index + 1]
        }
        return nums
    }

    fun productExceptSelfWithDivision(nums: IntArray): IntArray {
        val zeroes = mutableListOf<Int>()
        var total = 1
        nums.forEachIndexed { index, num ->
            if (num == 0) {
                zeroes.add(index)
            } else {
                total *= num
            }
        }
        val output = mutableListOf<Int>()
        for (i in nums.indices) {
            if (zeroes.size > 1) {
                output.add(0)
            } else {
                when {
                    i in zeroes -> output.add(total)
                    zeroes.isNotEmpty() -> output.add(0)
                    else -> output.add(total / nums[i])
                }
            }
        }
        return output.toIntArray()
    }

}
