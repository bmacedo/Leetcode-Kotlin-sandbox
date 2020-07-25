package challenges.july30DaysChallenge

/**
 * Island Perimeter
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0
 * represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 *
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more
 * connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 *
 * One cell is a square with side length 1.
 *
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 0, 0)
    )
    println(Leetcode30DayChallenge7.islandPerimeter(input))
}

object Leetcode30DayChallenge7 {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    perimeter += grid.countBorders(row, col)
                }
            }
        }
        return perimeter
    }

    private fun Array<IntArray>.countBorders(row: Int, col: Int): Int {
        val top = if (row == 0 || this[row - 1][col] == 0) 1 else 0
        val bottom = if (row == lastIndex || this[row + 1][col] == 0) 1 else 0
        val left = if (col == 0 || this[row][col - 1] == 0) 1 else 0
        val right = if (col == this[row].lastIndex || this[row][col + 1] == 0) 1 else 0
        return top + bottom + left + right
    }
}
