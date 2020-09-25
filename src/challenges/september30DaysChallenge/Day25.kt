package challenges.september30DaysChallenge

import java.util.*


/**
 * Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 */
fun main(args: Array<String>) {
    println(Day25.largestNumber(intArrayOf(824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247)))
}

object Day25 {

    // O(n logn) time, O(n) space
    fun largestNumber(nums: IntArray): String {
        return nums.sortedWith(comparator())
                .joinToString("")
                .trimStart('0')
                .takeIf { it.isNotEmpty() }
                ?: "0"
    }

    private fun comparator(): Comparator<Int> {
        return kotlin.Comparator { o1, o2 ->
            val comparison = "$o2$o1".toLong() - "$o1$o2".toLong()
            when {
                comparison > 0 -> 1
                comparison < 0 -> -1
                else -> 0
            }
        }
    }
}