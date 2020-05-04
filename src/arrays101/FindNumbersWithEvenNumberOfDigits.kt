package arrays101

/**
 * Find Numbers with Even Number of Digits
 *
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(12,345,2,6,7896)
    println(FindNumbersWithEvenNumberOfDigits.findNumbers(input))
}

object FindNumbersWithEvenNumberOfDigits {
    fun findNumbers(nums: IntArray): Int = nums.fold(0) { acc, num ->
        if (hasEvenNumberOfDigits(num)) acc + 1 else acc
    }

    private fun hasEvenNumberOfDigits(num: Int): Boolean {
        var numDigits = 0
        var result = num
        while (result != 0) {
            result /= 10
            numDigits++
        }
        return numDigits % 2 == 0
    }
}