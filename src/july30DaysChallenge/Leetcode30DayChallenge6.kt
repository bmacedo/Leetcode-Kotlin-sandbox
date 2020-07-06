package july30DaysChallenge

/**
 * Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element
 * in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 3)
    println(Leetcode30DayChallenge6.plusOne(input).toList())
}

object Leetcode30DayChallenge6 {

    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) return digits

        val lastDigit = digits.last() + 1
        var carryOver = if (lastDigit > 9) 1 else 0
        val result = mutableListOf(lastDigit % 10)

        var i = digits.lastIndex - 1
        while (i >= 0) {
            val nextDigit = digits[i] + carryOver
            carryOver = if (nextDigit > 9) 1 else 0
            result.add(0, nextDigit % 10)
            i--
        }
        if (carryOver != 0) result.add(0, carryOver)

        return result.toIntArray()
    }

}
