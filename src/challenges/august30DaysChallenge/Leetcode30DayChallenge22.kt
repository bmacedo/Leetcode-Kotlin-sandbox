package challenges.august30DaysChallenge

import java.util.*


/**
 * Random Point in Non-overlapping Rectangles
 *
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly
 * and uniformily picks an integer point in the space covered by the rectangles.
 *
 * Note:
 * - An integer point is a point that has integer coordinates
 *
 * - A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 *
 * - ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
 *
 * - length and width of each rectangle does not exceed 2000.
 *
 * - 1 <= rects.length <= 100
 *
 * - pick return a point as an array of integer coordinates [p_x, p_y]
 *
 * - pick is called at most 10000 times.
 */
fun main(args: Array<String>) {
    val solution = Leetcode30DayChallenge22.Solution(arrayOf(
            intArrayOf(-2, -2, -1, -1),
            intArrayOf(1, 0, 3, 0)
    ))
    println(solution.pick().toList())
}

object Leetcode30DayChallenge22 {


    class Solution(rects: Array<IntArray>) {

        private var random: Random = Random()
        private var map: TreeMap<Int, IntArray> = TreeMap()
        private var areaSum = 0

        init {
            for (i in rects.indices) {
                val rectangeCoordinates = rects[i]
                val length = rectangeCoordinates[2] - rectangeCoordinates[0] + 1 // +1 as we need to consider edges also.
                val breadth = rectangeCoordinates[3] - rectangeCoordinates[1] + 1

                areaSum += length * breadth

                map[areaSum] = rectangeCoordinates

            }

        }

        fun pick(): IntArray {
            val key = map.ceilingKey(random.nextInt(areaSum) + 1) //Don't forget to +1 here, because we need [1,area] while nextInt generates [0,area-1]

            val rectangle = map[key]

            val length = rectangle!![2] - rectangle[0] + 1 // +1 as we need to consider edges also.
            val breadth = rectangle[3] - rectangle[1] + 1

            val x = rectangle[0] + random.nextInt(length) //return random length from starting position of x
            val y = rectangle[1] + random.nextInt(breadth) // return random breadth from starting position of y

            return intArrayOf(x, y)

        }
    }
}