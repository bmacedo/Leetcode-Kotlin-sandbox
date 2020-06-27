package june30DaysChallenge


/**
 * Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 */
fun main(args: Array<String>) {
    val input = 48
    println(Leetcode30DayChallenge27.numSquares(input))
}

object Leetcode30DayChallenge27 {

    fun numSquares(n: Int): Int {
        val hash = IntArray(n + 1) { 0 }
        for (x in 1..n) {
            var min = x // take all 1's
            var y = 1
            var sq = 1
            while (sq <= x) {
                min = minOf(min, 1 + hash[x - sq])
                y++
                sq = y * y
            }
            hash[x] = min
        }
        return hash[n]
    }
}
