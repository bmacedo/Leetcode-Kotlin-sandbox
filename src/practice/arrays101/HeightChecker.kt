package practice.arrays101

/**
 * Height Checker
 *
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students that must move in order for all students to be
 * standing in non-decreasing order of height.
 *
 * Notice that when a group of students is selected they can reorder in any possible way
 * between themselves and the non selected students remain on their seats.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1,2,3,5,4)
    println(HeightChecker.heightChecker(input))
}

object HeightChecker {
    fun heightChecker(heights: IntArray): Int {
        val sortedHeights = heights.sorted()
        return heights.foldIndexed(0) { index, acc, height ->
            if (height != sortedHeights[index]) acc + 1 else acc
        }
    }
}