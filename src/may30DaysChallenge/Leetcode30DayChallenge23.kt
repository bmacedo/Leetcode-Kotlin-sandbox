package may30DaysChallenge

import utils.asIntMatrix


/**
 * Interval List Intersections
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 */
fun main(args: Array<String>) {
    val a = """
        [3,5],
        [9,20]
        """.trimMargin().asIntMatrix()

    val b = """
        [4,5],
        [7,10],
        [11,12],
        [14,15],
        [16,20]
        """.trimMargin().asIntMatrix()

    Leetcode30DayChallenge23
            .intervalIntersection(a, b)
            .forEach { println(it.toList()) }
}

object Leetcode30DayChallenge23 {

    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        var aPtr = 0
        var bPtr = 0
        val output = mutableListOf<IntArray>()
        while (aPtr < A.size && bPtr < B.size) {
            val (s1, e1) = A[aPtr][0] to A[aPtr][1]
            val (s2, e2) = B[bPtr][0] to B[bPtr][1]

            if (s1 <= e2 && s2 <= e1) {
                output.add(intArrayOf(Math.max(s1, s2), Math.min(e1, e2)))
            }
            if (e1 < e2) {
                aPtr++
            } else {
                bPtr++
            }
        }
        return output.toTypedArray()
    }
}

