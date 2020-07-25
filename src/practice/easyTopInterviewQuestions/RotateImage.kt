package practice.easyTopInterviewQuestions

/**
 * Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note: You have to rotate the image in-place, which means you have to modify the input
 * 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8)
    )

    RotateImage.rotate(input)

    println("----done----")
    for (i in input.indices) {
        for (j in input[i].indices) {
            print("${input[i][j]}\t")
        }
        println()
    }
}

object RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        val len = matrix.size - 1

        // 1. transpose: swap all non-diagonal nums and swap the rows/col
        for (i in 0..len) {
            for (j in i..len) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        // 2. flip: reverse each row
        for (i in 0..len) {
            for (j in 0..len / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][len - j]
                matrix[i][len - j] = temp
            }
        }
    }
}