package may30DaysChallenge


/**
 * Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert
 * word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 */
fun main(args: Array<String>) {
    val word1 = "intention"
    val word2 = "execution"
    println(Leetcode30DayChallenge31.minDistance(word1, word2))
}

object Leetcode30DayChallenge31 {

    //      ''  h   o   r   s   e
    // ''   0   1   2   3   4   5
    // r    1   1   2   2   3   4
    // o    2   2   1   2   3   4
    // s    3   3   2   2   2   3
    //
    // ans = dp[last][last] = 3


    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word2.length + 1) { IntArray(word1.length + 1) { 0 } }

        for (row in 1 until dp.size) dp[row][0] = dp[row - 1][0] + 1
        for (column in 1 until dp[0].size) dp[0][column] = dp[0][column - 1] + 1

        for (row in 1 until dp.size) {
            for (column in 1 until dp[0].size) {
                val charWord1 = word1[column - 1]
                val charWord2 = word2[row - 1]
                if (charWord1 == charWord2) {
                    // no changes needed
                    dp[row][column] = dp[row - 1][column - 1]
                } else {
                    val delete = dp[row][column - 1]
                    val insert = dp[row - 1][column]
                    val replace = dp[row - 1][column - 1]
                    val min = listOf(replace, delete, insert).min()!!
                    dp[row][column] = min + 1
                }
            }
        }
        val lastRow = dp.lastIndex
        val lastColumn = dp[lastRow].lastIndex
        return dp[lastRow][lastColumn]
    }
}

