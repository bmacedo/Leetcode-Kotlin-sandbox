package may30DaysChallenge

import utils.ListNode
import utils.toList
import utils.toListNode

/**
 * Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 *
 * The order of output does not matter.
 */
fun main(args: Array<String>) {
    val input = "cbaebabacd"
    val p = "abc"
    println(Leetcode30DayChallenge17.findAnagrams(input, p))
}

object Leetcode30DayChallenge17 {

    // based on the sliding window algorithm
    // O(n) time, O(n) space
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.isEmpty() || p.isEmpty() || p.length > s.length) return emptyList()

        val output = mutableListOf<Int>()
        var anagramCount = p.length
        val hash = IntArray(26)
        var start = 0
        var end = 0

        // fill hash with repetition of chars in p
        p.forEach { char -> hash[char - 'a']++ }

        while (end < s.length) {
            // decrease anagram count if arr[end] matches a char in hash with count > 0
            if (hash[s[end] - 'a']-- > 0) {
                anagramCount--
            }
            end++

            // if anagramCount is zero, add start index to output result
            if (anagramCount == 0) output.add(start)

            // if the distance between start and end is the size of p, undo the anagram count
            // decrease and update the start to be equal to the current end
            if (end - start == p.length) {
                if (hash[s[start] - 'a']++ >= 0) {
                    anagramCount++
                }
                start++
            }
        }
        return output
    }

    // groups the string into slices of size p, then sorts each slice
    // and compares with the sorted p
    // O(nlogn) time, O(n) space
    fun findAnagramsBasedOnSort(s: String, p: String): List<Int> {
        val output = mutableListOf<Int>()
        val sortedP = p.toCharArray().sorted()
        var i = 0
        while (i < s.length - p.lastIndex) {
            val subStr = s.subSequence(i, i + p.length).toString().toCharArray().sorted()
            if (subStr == sortedP) output.add(i)
            i++
        }
        return output
    }
}


