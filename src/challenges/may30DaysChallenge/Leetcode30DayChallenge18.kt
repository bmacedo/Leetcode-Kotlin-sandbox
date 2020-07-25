package challenges.may30DaysChallenge

/**
 * Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 *
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Note:
 * -    The input strings only contain lower case letters.
 * -    The length of both given strings is in range [1, 10,000].
 */
fun main(args: Array<String>) {
    val s1 = "ab"
    val s2 = "eidbaooo"
    println(Leetcode30DayChallenge18.checkInclusion(s1, s2))
}

object Leetcode30DayChallenge18 {


    // O(n) time, O(1) space
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.isEmpty()) return true
        if (s2.isEmpty() || s1.length > s2.length) return false

        val hash = IntArray(26)
        var start = 0
        var end = 0
        var count = s1.length
        s1.forEach { hash[it - 'a']++ }

        while (end < s2.length) {
            if (hash[s2[end] - 'a'] > 0) count--
            hash[s2[end] - 'a']--
            end++

            if (count == 0) return true

            if (end - start == s1.length) {
                if (hash[s2[start] - 'a'] >= 0) count++
                hash[s2[start] - 'a']++
                start++
            }
        }
        return false
    }
}


