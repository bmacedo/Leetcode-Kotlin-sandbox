package challenges.april30DaysChallenge

/**
 * Happy Number
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 */
fun main(args: Array<String>) {
    val input = 19
    println(Leetcode30DayChallenge2.isHappy(input))
}

object Leetcode30DayChallenge2 {

    fun isHappy(n: Int): Boolean {
        var digits = destruct(n)
        repeat(10000) {
            val sum = digits.map { it * it }.sum()

            if (sum == 1) {
                return true
            }

            digits = destruct(sum)
        }
        return false
    }

    private fun destruct(n: Int) = n.toString().split("").mapNotNull { it.toIntOrNull() }
}
