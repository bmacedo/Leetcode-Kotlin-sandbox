package challenges.june30DaysChallenge


/**
 * Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 *
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
fun main(args: Array<String>) {
    val m = 7
    val n = 3
    println(Leetcode30DayChallenge29.uniquePaths(m, n))
}

object Leetcode30DayChallenge29 {


    fun uniquePaths(m: Int, n: Int): Int {
        val hash = Array(m) { IntArray(n) { -1 } }

        for (i in 0 until m) hash[i][0] = 1
        for (j in 0 until n) hash[0][j] = 1

        return countPaths(m - 1, n - 1, hash)
    }

    private fun countPaths(m: Int, n: Int, hash: Array<IntArray>): Int {
        if (hash[m][n] != -1) return hash[m][n]
        val result = countPaths(m - 1, n, hash) + countPaths(m, n - 1, hash)
        hash[m][n] = result
        return result
    }
}
