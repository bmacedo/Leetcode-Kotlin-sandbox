package challenges.june30DaysChallenge

/**
 * Is Subsequence
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check
 * one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
fun main(args: Array<String>) {
    val s = "abc"
    val t = "ahbgdc"
    println(Leetcode30DayChallenge9.isSubsequence(s, t))
}

object Leetcode30DayChallenge9 {

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        var i = 0
        var j = 0
        while (i < t.length && j < s.length) {
            if (t[i] == s[j]) j++
            i++
        }
        return j == s.length
    }
}