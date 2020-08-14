package challenges.august30DaysChallenge

import kotlin.test.assertEquals

/**
 * Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
 * that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note: Assume the length of given string will not exceed 1,010.
 */
fun main(args: Array<String>) {
    assertEquals(7, Leetcode30DayChallenge14.longestPalindrome("abccccdd"))
    assertEquals(6, Leetcode30DayChallenge14.longestPalindrome("abccba"))
    assertEquals(1, Leetcode30DayChallenge14.longestPalindrome("a"))
    assertEquals(3, Leetcode30DayChallenge14.longestPalindrome("aba"))
    assertEquals(3, Leetcode30DayChallenge14.longestPalindrome("abad"))
    assertEquals(3, Leetcode30DayChallenge14.longestPalindrome("ccc"))
    println("Success")
}

object Leetcode30DayChallenge14 {

    // A palindrome demands an even number of the same letters and can accommodate up to 1 extra single letter
    // Therefore, we can count the letters, separating them into buckets and sum the number of letters that appear
    // an even number of times and those that appear an odd number of times.
    // The result will be the amount of letters in the even group + at most 1 from the odd group
    // O(n) time, O(n) space
    fun longestPalindrome(s: String): Int {
        val map = HashMap<Char, Int>() // Char, Count

        for (char in s) {
            map[char] = map.getOrDefault(char, 0) + 1
        }

        var countPairs = 0
        map.forEach { (_, times) -> countPairs += times / 2 }
        val evenCount = countPairs * 2
        val extraOddInMiddle = if (evenCount == s.length) 0 else 1

        return evenCount + extraOddInMiddle
    }
}