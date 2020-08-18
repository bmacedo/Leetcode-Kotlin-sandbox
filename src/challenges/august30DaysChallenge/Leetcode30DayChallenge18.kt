package challenges.august30DaysChallenge

import kotlin.test.assertEquals


/**
 * Numbers With Same Consecutive Differences
 *
 * Return all non-negative integers of length N such that the absolute difference between every two
 * consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself.
 * For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 */
fun main(args: Array<String>) {
    assertEquals(
            intArrayOf(181, 292, 707, 818, 929).toList().sorted(),
            Leetcode30DayChallenge18.numsSameConsecDiff(3, 7).toList().sorted()
    )
    assertEquals(
            intArrayOf(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98).toList().sorted(),
            Leetcode30DayChallenge18.numsSameConsecDiff(2, 1).toList().sorted()
    )
    assertEquals(
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).toList().sorted(),
            Leetcode30DayChallenge18.numsSameConsecDiff(1, 1).toList().sorted()
    )
    assertEquals(
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).toList().sorted(),
            Leetcode30DayChallenge18.numsSameConsecDiff(1, 0).toList().sorted()
    )
    println("Success")
}

object Leetcode30DayChallenge18 {

    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        var current = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (i in 2..N) {
            val list = mutableListOf<Int>()
            for (num in current) {
                val lastDigit = num % 10
                if (num > 0 && lastDigit + K < 10)
                    list.add(num * 10 + lastDigit + K)
                if (num > 0 && K > 0 && lastDigit - K >= 0)
                    list.add(num * 10 + lastDigit - K)
            }
            current = list
        }
        return current.toIntArray()
    }
}