package challenges.may30DaysChallenge

import utils.print
import java.util.*


/**
 * K Closest Points to Origin
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.
 *
 * The answer is guaranteed to be unique (except for the order that it is in.)
 */
fun main(args: Array<String>) {
    val points = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
    val K = 2
    Leetcode30DayChallenge30.kClosest(points, K).print()
}

object Leetcode30DayChallenge30 {

    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val distances = TreeMap<Double, List<IntArray>>()
        points.forEach { point ->
            val (x, y) = point
            val previousValue = distances[Math.sqrt((x * x) + (y * y).toDouble())] ?: emptyList()
            distances[Math.sqrt((x * x) + (y * y).toDouble())] = previousValue + point
        }
        return distances.values.flatten().take(K).toTypedArray()
    }
}

