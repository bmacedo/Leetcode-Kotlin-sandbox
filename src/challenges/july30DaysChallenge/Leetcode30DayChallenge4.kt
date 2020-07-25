package challenges.july30DaysChallenge

/**
 * Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
fun main(args: Array<String>) {
    val n = 10
    println(Leetcode30DayChallenge4.nthUglyNumber(n))
}

object Leetcode30DayChallenge4 {

    fun nthUglyNumber(n: Int): Int {
        val result = IntArray(n).apply { this[0] = 1 }
        var last2 = 0
        var last3 = 0
        var last5 = 0

        for (i in 1 until n) {
            val candidate1 = result[last2] * 2
            val candidate2 = result[last3] * 3
            val candidate3 = result[last5] * 5

            val next = minOf(candidate1, candidate2, candidate3)
            result[i] = next

            if (next == candidate1) last2++
            if (next == candidate2) last3++
            if (next == candidate3) last5++
        }

        return result[n - 1]
    }

}
