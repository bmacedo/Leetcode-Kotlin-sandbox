package challenges.september30DaysChallenge

import utils.asIntMatrix


/**
 * Image Overlap
 *
 * Two images A and B are given, represented as binary, square matrices of the same size.
 * (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number
 * of units), and place it on top of the other image.
 *
 * After, the overlap of this translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 */
fun main(args: Array<String>) {
    val matrix1 = """
        [[1,1,0],
        [0,1,0],
        [0,1,0]]
        """.trimIndent().asIntMatrix()
    val matrix2 = """
        [[0,0,0],
        [0,1,1],
        [0,0,1]]
        """.trimIndent().asIntMatrix()
    println(Day6.largestOverlap(matrix1, matrix2))
}

object Day6 {

    fun largestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int {
        var largestOverlap = 0
        for (row in -A.size + 1 until A.size)
            for (col in -A[0].size + 1 until A[0].size)
                largestOverlap = Math.max(largestOverlap, overlappingOnes(A, B, row, col))
        return largestOverlap
    }

    private fun overlappingOnes(A: Array<IntArray>, B: Array<IntArray>, rowOffset: Int, colOffset: Int): Int {
        var overlapOnes = 0
        for (row in A.indices) {
            for (col in 0 until A[0].size) {
                if (row + rowOffset < 0 || row + rowOffset >= A.size ||
                        col + colOffset < 0 || col + colOffset >= A.size ||
                        A[row][col] + B[row + rowOffset][col + colOffset] != 2) {
                    continue
                }
                overlapOnes++
            }
        }
        return overlapOnes
    }
}


