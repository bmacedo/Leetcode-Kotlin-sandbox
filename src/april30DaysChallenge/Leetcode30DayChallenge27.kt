package april30DaysChallenge


/**
 * Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 */
fun main(args: Array<String>) {
    // expect: 9
    val input = arrayOf(
            "0001".toCharArray(),
            "1101".toCharArray(),
            "1111".toCharArray(),
            "0111".toCharArray(),
            "0111".toCharArray()
    )

    println(Leetcode30DayChallenge27.maximalSquare(input))
}

object Leetcode30DayChallenge27 {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        var maxSquareSide = 0
        for (rowIndex in matrix.indices) {
            for (columnIndex in matrix[rowIndex].indices) {
                if (matrix[rowIndex][columnIndex] == '1') {
                    val squareSide = visitSquare(matrix, rowIndex, columnIndex, 1)
                    if (maxSquareSide < squareSide) {
                        maxSquareSide = squareSide
                    }
                }
            }
        }
        return maxSquareSide * maxSquareSide
    }

    private fun visitSquare(matrix: Array<CharArray>, rowIndex: Int, columnIndex: Int, size: Int): Int {
        val checkColumn = columnIndex + size
        if (checkColumn < matrix[rowIndex].size) {
            val checkRow = rowIndex + size
            if (checkRow < matrix.size) {
                for (i in rowIndex..checkRow) {
                    if (matrix[i][checkColumn] != '1') return size
                }
                for (i in columnIndex until checkColumn) {
                    if (matrix[checkRow][i] != '1') return size
                }
                return visitSquare(matrix, rowIndex, columnIndex, size + 1)
            }
        }
        return size
    }
}
