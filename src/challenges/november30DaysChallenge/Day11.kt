package challenges.november30DaysChallenge

import kotlin.math.sqrt

/**
 * Valid Square
 *
 * Given the coordinates of four points in 2D space, return whether the four points could
 * construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
fun main(args: Array<String>) {
    println(Day11.validSquare(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1)))
}

object Day11 {
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        fun Double.equalsDelta(other: Double) = Math.abs(this - other) < Math.max(Math.ulp(this), Math.ulp(other)) * 2
        fun distanceBetween(p0: IntArray, p1: IntArray): Double {
            val (x0,y0) = p0
            val (x1, y1) = p1
            val squareDistance = (x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)
            return Math.sqrt(squareDistance.toDouble())
        }

        val points = listOf(p1,p2,p3,p4)
        for (p in points) {
            val remainingPoints = points - p
            val distances = remainingPoints.map {
                distanceBetween(p, it)
            }
            val max = distances.max()!!
            val min = distances.min()!!
            val diagonal = min * Math.sqrt(2.0)

            if (distances.filter { it == min }.size != 2 || !diagonal.equalsDelta(max)) {
                return false
            }
        }
        return true
    }
}