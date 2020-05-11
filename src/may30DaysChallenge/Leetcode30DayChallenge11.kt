package may30DaysChallenge

/**
 * Flood Fill
 *
 * An image is represented by a 2-D array of integers, each integer representing the pixel
 * value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood
 * fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
 *
 * Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 */
fun main(args: Array<String>) {
    val input = arrayOf<IntArray>(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
    )
    val i = 1
    val j = 1
    val newColor = 1
    val result = Leetcode30DayChallenge11.floodFill(input, i, j, newColor)
    for (l in result.indices) {
        for (k in result[i].indices) {
            print("${result[l][k]} ")
        }
        println()
    }
}

object Leetcode30DayChallenge11 {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        fill(image, sr, sc, image[sr][sc], -1)
        fill(image, sr, sc, -1, newColor)
        return image
    }

    private fun fill(image: Array<IntArray>, sr: Int, sc: Int, color: Int, newColor: Int) {
        if (sr in image.indices && sc in image[sr].indices && image[sr][sc] == color) {
            image[sr][sc] = newColor
            fill(image, sr - 1, sc, color, newColor)
            fill(image, sr + 1, sc, color, newColor)
            fill(image, sr, sc - 1, color, newColor)
            fill(image, sr, sc + 1, color, newColor)
        }
    }
}


