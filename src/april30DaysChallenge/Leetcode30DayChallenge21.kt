package april30DaysChallenge

import utils.BinaryMatrix


/**
 * Leftmost Column with at Least a One
 * (This problem is an interactive problem.)
 *
 * A binary matrix means that all elements are 0 or 1.
 * For each individual row of the matrix, this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed)
 * with at least a 1 in it. If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.
 * You may only access the matrix using a BinaryMatrix interface:
 * -    BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * -    BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 *
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 */
fun main(args: Array<String>) {
    val input = BinaryMatrix(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 0)
    )

    println(Leetcode30DayChallenge21.leftMostColumnWithOne(input))
}

object Leetcode30DayChallenge21 {
    // O(N)
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val (rows, columns) = binaryMatrix.dimensions()
        var pointer = Pair(0, columns - 1)
        var result = -1

        while (true) {
            val value = binaryMatrix.get(pointer.first, pointer.second)
            val newPosition = if (value == 0) {
                moveDown(pointer, rows)
            } else {
                result = updateResult(result, pointer)
                moveLeft(pointer)
            }
            if (newPosition == pointer) return result
            pointer = newPosition
        }
    }

    private fun updateResult(result: Int, pointer: Pair<Int, Int>) =
            if (result == -1) pointer.second else result.coerceAtMost(pointer.second)

    private fun moveLeft(pointer: Pair<Int, Int>): Pair<Int, Int> {
        val (currentRow, currentColumn) = pointer
        return if (currentColumn > 0) Pair(currentRow, currentColumn - 1) else pointer
    }

    private fun moveDown(pointer: Pair<Int, Int>, rows: Int): Pair<Int, Int> {
        val (currentRow, currentColumn) = pointer
        return if (currentRow < rows - 1) Pair(currentRow + 1, currentColumn) else pointer
    }

    // O(N log(n))
    fun leftMostColumnWithOneWithBinarySearch(binaryMatrix: BinaryMatrix): Int {
        val (rows, columns) = binaryMatrix.dimensions()
        var leftMostColumnWithOne = columns - 1
        var found = false
        var rowIndex = 0
        while (rowIndex < rows) {
            val indexOfFirstOne = findFirstOneAtRow(binaryMatrix, rowIndex, leftMostColumnWithOne)
            if (indexOfFirstOne != -1 && indexOfFirstOne <= leftMostColumnWithOne) {
                leftMostColumnWithOne = indexOfFirstOne
                found = true
            }
            rowIndex++
        }
        return if (found) leftMostColumnWithOne else -1
    }

    private fun findFirstOneAtRow(binaryMatrix: BinaryMatrix, rowIndex: Int, lastIndex: Int): Int {
        var startIndex = 0
        var endIndex = lastIndex

        if (binaryMatrix.get(rowIndex, lastIndex) == 0) return -1

        while (startIndex < endIndex) {
            val midPointIndex = (startIndex + endIndex) / 2
            val value = binaryMatrix.get(rowIndex, midPointIndex)
            if (value == 1) {
                endIndex = midPointIndex
            } else {
                startIndex = midPointIndex + 1
            }
        }

        return startIndex
    }
}
