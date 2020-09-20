package challenges.september30DaysChallenge

/**
 * Unique Paths III
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 * - 1 represents the starting square.  There is exactly one starting square.
 * - 2 represents the ending square.  There is exactly one ending square.
 * - 0 represents empty squares we can walk over.
 * - -1 represents obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 */
fun main(args: Array<String>) {
    println(Day20.uniquePathsIII(
            arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 2, -1)
            )
    ))
}

object Day20 {

    var result = 0
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var start: Pair<Int, Int>? = null
        var end: Pair<Int, Int>? = null
        var pathSize = 2
        for (rowIndex in grid.indices) {
            for (colIndex in grid[0].indices) {
                when {
                    grid[rowIndex][colIndex] == 1 -> {
                        start = rowIndex to colIndex
                        grid[rowIndex][colIndex] = 0
                    }
                    grid[rowIndex][colIndex] == 2 -> {
                        end = rowIndex to colIndex
                        grid[rowIndex][colIndex] = 0
                    }
                    grid[rowIndex][colIndex] == 0 -> pathSize++
                }
            }
        }

        val visited = HashSet<Pair<Int, Int>>().apply { add(start!!) }
        backtrack(start!!, end!!, grid, visited, pathSize)
        return result
    }

    private fun backtrack(current: Pair<Int, Int>,
                          end: Pair<Int, Int>,
                          grid: Array<IntArray>,
                          visited: HashSet<Pair<Int, Int>>,
                          pathSize: Int) {
        val (x, y) = current
        if (current == end && visited.size == pathSize) {
            result++
            return
        }

        val options = listOf(x + 1 to y, x to y + 1, x - 1 to y, x to y - 1)
        for (option in options) {
            val (optX, optY) = option
            if (optX in grid.indices && optY in grid[0].indices && grid[optX][optY] == 0 && option !in visited) {
                visited.add(option)
                backtrack(option, end, grid, visited, pathSize)
                visited.remove(option)
            }
        }
    }
}