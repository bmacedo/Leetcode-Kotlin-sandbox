package challenges.october30DaysChallenge

/**
 * Remove Covered Intervals
 *
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 */
fun main(args: Array<String>) {
    val intervals = arrayOf(
            intArrayOf(0, 10),
            intArrayOf(5, 12)
    )
    println(Day4.removeCoveredIntervals(intervals))
}

object Day4 {

    // O(n logn) time, O(1) space
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy({ it[0] }, { it[0] - it[1] }))

        var res = 1

        var i = 0
        var j = 0

        while (i < intervals.size && j < intervals.size) {
            val first = intervals[i]
            val second = intervals[j]

            if (first[1] >= second[1]) {
                j++
            } else {
                i = j
                j++
                res++
            }
        }

        return res
    }

    // O(n square) time, O(n) space
    fun removeCoveredIntervalsSlow(intervals: Array<IntArray>): Int {
        if (intervals.size < 2) return intervals.size

        val mutableIntervals = intervals.toMutableList()
        val iterator = mutableIntervals.iterator()

        while (iterator.hasNext()) {
            val interval = iterator.next()
            val range1 = IntRange(interval[0], interval[1])
            if (intervals.shouldRemove(range1)) {
                iterator.remove()
            }
        }
        return mutableIntervals.size
    }

    private fun Array<IntArray>.shouldRemove(range1: IntRange): Boolean {
        forEach { other ->
            val range2 = IntRange(other[0], other[1])
            if (range2 != range1 && range2.contains(range1)) return true
        }
        return false
    }

    private fun IntRange.contains(other: IntRange): Boolean {
        return this.start <= other.start && other.endInclusive <= this.endInclusive
    }
}