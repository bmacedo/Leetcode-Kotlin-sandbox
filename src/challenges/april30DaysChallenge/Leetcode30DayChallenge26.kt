package challenges.april30DaysChallenge


/**
 * Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining
 * characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 */

fun main(args: Array<String>) {
    val text1 = "pmjghexybyrgzczy"
    val text2 = "hafcdqbgncrcbihkd"
    println(Leetcode30DayChallenge26.longestCommonSubsequence(text1, text2))
}

object Leetcode30DayChallenge26 {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val length1 = text1.length
        val length2 = text2.length

        val maxLengths = Array(length1 + 1) { IntArray(length2 + 1) }
        for (i in 0..length1) {
            for (j in 0..length2) {
                if (i != 0 && j != 0) {
                    if (text1[i - 1] == text2[j - 1]) {
                        maxLengths[i][j] = maxLengths[i - 1][j - 1] + 1
                    } else {
                        maxLengths[i][j] = Math.max(maxLengths[i - 1][j], maxLengths[i][j - 1])
                    }
                }
            }
        }

        return maxLengths[length1][length2]
    }
}
