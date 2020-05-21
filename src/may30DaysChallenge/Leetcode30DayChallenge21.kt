package may30DaysChallenge

import utils.asIntMatrix
import utils.print


/**
 * Count Square Submatrices with All Ones
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */
fun main(args: Array<String>) {
    val input = """
      [1,0,1],
      [1,1,0],
      [1,1,0]
        """.trimIndent().asIntMatrix()

    input.print()


    println(Leetcode30DayChallenge21.countSquares(input))
}

object Leetcode30DayChallenge21 {


    // uses dynamic programming by modifying the bottom left corner of the square
    // to mark the amount of squares that use that particular corner.
    // later on we just sum up the numbers of the matrix to get the result
    fun countSquares(matrix: Array<IntArray>): Int {
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[i].size) {
                if (matrix[i][j] != 0) {
                    val value = 1 + listOf(matrix[i - 1][j], matrix[i - 1][j - 1], matrix[i][j - 1]).min()!!
                    matrix[i][j] = value
                }
            }
        }
        return matrix.map { it.sum() }.sum()
    }

    // Brute force solution
    fun countSquaresBF(matrix: Array<IntArray>): Int {
        val hash = HashSet<List<Pair<Int, Int>>>()
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, item ->
                if (item == 1) {
                    hash.add(listOf(rowIndex to columnIndex))
                    markSquares(hash, matrix, rowIndex, columnIndex, 2)
                }
            }
        }
        return hash.count()
    }

    private fun markSquares(hash: HashSet<List<Pair<Int, Int>>>, matrix: Array<IntArray>, rowIndex: Int, columnIndex: Int, squareSize: Int) {
        val lastRow = rowIndex + squareSize - 1
        val lastColumn = columnIndex + squareSize - 1
        if (lastRow in matrix.indices && lastColumn in matrix[rowIndex].indices) {
            if (isSquare(rowIndex, lastRow, columnIndex, lastColumn, matrix)) {
                val topLeft = rowIndex to columnIndex
                val topRight = rowIndex to lastColumn
                val bottomLeft = lastRow to columnIndex
                val bottomRight = lastRow to lastColumn
                hash.add(listOf(topLeft, topRight, bottomRight, bottomLeft))
            }
            if (lastRow + 1 in matrix.indices && lastColumn + 1 in matrix[lastRow + 1].indices && matrix[lastRow + 1][lastColumn + 1] == 1) {
                markSquares(hash, matrix, rowIndex, columnIndex, squareSize + 1)
            }
        }
    }

    private fun isSquare(rowIndex: Int, lastRow: Int, columnIndex: Int, lastColumn: Int, matrix: Array<IntArray>): Boolean {
        var isSquare = true
        for (i in rowIndex..lastRow) {
            for (j in columnIndex..lastColumn) {
                if (matrix[i][j] != 1) {
                    isSquare = false
                    break
                }
            }
        }
        return isSquare
    }

}

