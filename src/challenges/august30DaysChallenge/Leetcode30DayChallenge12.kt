package challenges.august30DaysChallenge

/**
 * Pascal's Triangle II
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Follow up: Could you optimize your algorithm to use only O(k) extra space?
 */
fun main(args: Array<String>) {
    val k = 4
    println(Leetcode30DayChallenge12.getRow(k))
}

object Leetcode30DayChallenge12 {

    fun getRow(rowIndex: Int): List<Int> {
        val current = IntArray(rowIndex + 1).apply { this[0] = 1 }
        val next = current.copyOf()
        for (h in 0..rowIndex) {
            for (i in 1..h) next[i] = current[i - 1] + current[i]
            for (i in 0..h) current[i] = next[i]
        }
        return current.asList()
    }
}