package contests.biweeklyContest27

import utils.asIntMatrix

/**
 * Cherry Pickup II
 *
 * Given a rows x cols matrix grid representing a field of cherries.
 * Each cell in grid represents the number of cherries that you can collect.
 *
 * You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0),
 * and Robot #2 is located at the top-right corner (0, cols-1) of the grid.
 *
 * Return the maximum number of cherries collection using both robots  by following the rules below:
 * - From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
 * - When any robot is passing through a cell, It picks it up all cherries,
 * and the cell becomes an empty cell (0).
 * - When both robots stay on the same cell, only one of them takes the cherries.
 * - Both robots cannot move outside of the grid at any moment.
 * - Both robots should reach the bottom row in the grid.
 *
 */
fun main(args: Array<String>) {
    val grid = """
        [1,0,0,3],
        [0,0,0,3],
        [0,0,3,3],
        [9,0,3,3]
        """.trimIndent().asIntMatrix()

    println(CherryPickupII.cherryPickup(grid))
}

object CherryPickupII {
    // TODO
    fun cherryPickup(grid: Array<IntArray>): Int {
        var maxCherries = 0
        var robot1Position = 0 to 0
        var robot2Position = 0 to grid.size - 1
        val optionsRobot1 = listOf(1 to 0, 1 to 1)
        val optionsRobot2 = listOf(1 to grid.size - 1, 1 to grid.size - 2)

        optionsRobot1.forEach { rb1Opt ->
            optionsRobot2.forEach { rb2Opt ->
                val result = cherriesCollected(rb1Opt, rb2Opt, grid)
            }
        }

        // at each step, each robot as 3 choices:
        // go down-left, go down, go down-right
        // for next positions I have:
        // robot1 DL, robot2 DL
        // robot1 DD, robot2 DL
        // robot1 DR, robot2 DL
        // robot1 DL, robot2 DD
        // robot1 DD, robot2 DD
        // robot1 DR, robot2 DD
        // robot1 DL, robot2 DR
        // robot1 DD, robot2 DR
        // robot1 DR, robot2 DR

        return maxCherries
    }

    private fun cherriesCollected(robot1Position: Pair<Int, Int>, robot2Position: Pair<Int, Int>, grid: Array<IntArray>): Int {
        TODO("Not yet implemented")
    }
}