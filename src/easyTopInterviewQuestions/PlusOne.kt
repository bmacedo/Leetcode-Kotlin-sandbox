package easyTopInterviewQuestions

/**
 * Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(4,3,2,1)
    println(PlusOne.plusOne(input).toList())
}

object PlusOne {
    // O(n) time, O(n) space
    fun plusOne(digits: IntArray): IntArray {
        var carryOver = 1
        for (i in digits.lastIndex downTo 0) {
            val next = digits[i] + carryOver
            digits[i] = next % 10
            carryOver = next / 10
            if (carryOver == 0) break
        }
        return if (carryOver == 1) intArrayOf(1).plus(digits) else digits
    }
}