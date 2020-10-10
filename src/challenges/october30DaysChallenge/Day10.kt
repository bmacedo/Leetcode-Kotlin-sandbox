package challenges.october30DaysChallenge


/**
 * Minimum Number of Arrows to Burst Balloons
 *
 * There are some spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and
 * end of the diameter suffice. The start is always smaller than the end.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis.
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 * There is no limit to the number of arrows that can be shot.
 * An arrow once shot keeps traveling up infinitely.
 *
 * Given an array points where points[ i ] = [xstart, xend], return the minimum number of arrows
 * that must be shot to burst all balloons.
 */
fun main(args: Array<String>) {
    println(Day10.findMinArrowShots(arrayOf(
            intArrayOf(10, 16),
            intArrayOf(2, 8),
            intArrayOf(1, 6),
            intArrayOf(7, 12)
    )))
}

object Day10 {

    // O(n log n) time, O(1) space
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        points.sortBy { it[1] }

        var arrowCount = 1
        var arrowPos = points[0][1]

        for (i in 1 until points.size) {
            if (points[i][0] > arrowPos) {
                arrowCount++
                arrowPos = points[i][1]
            }
        }
        return arrowCount
    }
}