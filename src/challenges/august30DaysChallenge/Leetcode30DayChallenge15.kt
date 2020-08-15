package challenges.august30DaysChallenge

import kotlin.test.assertEquals

/**
 * Non-overlapping Intervals
 *
 * Given a collection of intervals, find the minimum number of intervals you need to
 * remove to make the rest of the intervals non-overlapping.
 */
fun main(args: Array<String>) {
    assertEquals(1, Leetcode30DayChallenge15.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3)
    )))
    assertEquals(2, Leetcode30DayChallenge15.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2)
    )))
    assertEquals(0, Leetcode30DayChallenge15.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 3)
    )))
    assertEquals(1, Leetcode30DayChallenge15.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 100), intArrayOf(2, 3), intArrayOf(3, 4)
    )))
    println("Success")
}

object Leetcode30DayChallenge15 {

    // Instead of erasing intervals, we can think about the problem as if we're trying to create the longest
    // possible list without intersections. The minimum number of intervals we'd need to remove will be the total number
    // of intervals minus the size of this longest list.
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        intervals.sortBy { it[1] }
        val n = intervals.size
        var current = intervals[0]
        var count = 1

        for (i in intervals.indices) {
            val (_, currentEnd) = current
            val (nextStart, _) = intervals[i]
            if (currentEnd <= nextStart) {
                count++
                current = intervals[i]
            }
        }

        return n - count
    }

    // TLE
    // This works, but is highly inefficient. It requires O(2ˆn) time since it backtracks recursively the
    // decision of which interval to remove (the current or the next) when an intersection is detected
    private fun eraseSortedOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        for (i in 0 until intervals.lastIndex) {
            val (_, currentEnd) = intervals[i]
            val (nextStart, _) = intervals[i + 1]
            if (currentEnd > nextStart) {
                val opt1 = intervals.filterIndexed { index, _ -> index != i }.toTypedArray()
                val opt2 = intervals.filterIndexed { index, _ -> index != i + 1 }.toTypedArray()
                return 1 + minOf(eraseSortedOverlapIntervals(opt1), eraseSortedOverlapIntervals(opt2))
            }
        }
        return 0
    }
}