package challenges.june30DaysChallenge

import utils.asIntMatrix
import utils.print


/**
 * Dungeon Game
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 *
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through
 * the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon
 * entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase
 * the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward
 * or downward in each step.
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the
 * princess.
 */
fun main(args: Array<String>) {
    val input = """
        [-2,-3,-3],
        [-5,-10,1],
        [10,30,-5]
        """.trimIndent().asIntMatrix()

    input.print()

    println(Leetcode30DayChallenge21.calculateMinimumHP(input))
}

object Leetcode30DayChallenge21 {

    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val length = dungeon.size
        val width: Int = dungeon[0].size
        val hp = Array(length) { IntArray(width) }
        for (i in length - 1 downTo 0) {
            for (j in width - 1 downTo 0) {
                var right = Int.MAX_VALUE
                if (j + 1 < width) right = hp[i][j + 1]
                var down = Int.MAX_VALUE
                if (i + 1 < length) down = hp[i + 1][j]
                var pre = minOf(right, down)
                if (pre == Int.MAX_VALUE) pre = 1
                hp[i][j] = pre - dungeon[i][j]
                if (hp[i][j] <= 0) hp[i][j] = 1
            }
        }
        return hp[0][0]
    }

}
