package challenges.may30DaysChallenge

/**
 * Check If It Is a Straight Line
 *
 * You are given an array coordinates, coordinates(i) = [x, y], where [x, y] represents
 * the coordinate of a point.
 *
 * Check if these points make a straight line in the XY plane.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            intArrayOf(1,1),
            intArrayOf(2,1),
            intArrayOf(3,1)
    )
    println(Leetcode30DayChallenge8.checkStraightLine(input))
}

object Leetcode30DayChallenge8 {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size < 2) return false
        val (x0, y0) = coordinates[0]
        val (x1, y1) = coordinates[1]
        val slope = (y1 - y0)/(x1 - x0).toFloat()
        for (i in 2 until coordinates.size) {
            val (x, y) = coordinates[i]
            val newSlope = (y - y0)/(x - x0).toFloat()
            if (slope != newSlope) return false
        }
        return true
    }
}


