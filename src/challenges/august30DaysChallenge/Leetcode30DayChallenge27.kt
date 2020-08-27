package challenges.august30DaysChallenge

import java.util.*


/**
 * Find Right Interval
 *
 * Given a set of intervals, for each of the interval i, check if there exists an
 * interval j whose start point is bigger than or equal to the end point of the
 * interval i, which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means
 * that the interval j has the minimum start point to build the "right" relationship
 * for interval i. If the interval j doesn't exist, store -1 for the interval i.
 *
 * Finally, you need output the stored value of each interval as an array.
 *
 * Note:
 * - You may assume the interval's end point is always bigger than its start point.
 * - You may assume none of these intervals have the same start point.
 */
fun main(args: Array<String>) {
    println(Leetcode30DayChallenge27.findRightInterval(arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
    )).toList())
}

object Leetcode30DayChallenge27 {

    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        if (intervals.size <= 1) return intArrayOf(-1)

        val map = TreeMap<Int?, Int>() // Start, Index
        intervals.forEachIndexed { index, (start, _) ->
            map[start] = index
        }

        val result = IntArray(intervals.size)
        intervals.forEachIndexed { index, (_, end) ->
            val key = map.ceilingKey(end)
            result[index] = key?.let { map[it] } ?: -1
        }
        return result
    }
}